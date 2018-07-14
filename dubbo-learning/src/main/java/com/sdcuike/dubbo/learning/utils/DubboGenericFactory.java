package com.sdcuike.dubbo.learning.utils;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * dubbo 泛化调用管理
 *
 * @author sdcuike
 * @date 2018/7/2
 * @since 2018/7/2
 */
public class DubboGenericFactory {

    private static final ApplicationConfig applicationConfig = new ApplicationConfig();

    static {
        // 当前应用配置
        applicationConfig.setName("dubbo.learning");
        applicationConfig.setOwner("dubbo.learning");
        applicationConfig.setOrganization("sdcuike.com");
    }

    public static GenericService get(String zookeeperAddress, String directUrl, String interfaceName, String interfaceVersion) {

        boolean b = StringUtils.isBlank(zookeeperAddress) && StringUtils.isBlank(directUrl);
        Preconditions.checkArgument(!b);
        Preconditions.checkArgument(StringUtils.isNotBlank(interfaceName));


        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(applicationConfig);

        RegistryConfig registryConfig = RegistryConfigFactory.get(zookeeperAddress);
        if (registryConfig != null) {
            reference.setRegistry(registryConfig);
        } else {
            //dubbo直连
            reference.setUrl(directUrl);
        }


        reference.setTimeout(6000);
        reference.setCheck(false);
        //声明为泛化接口
        reference.setGeneric(true);
        if (StringUtils.isNotBlank(interfaceVersion)) {
            reference.setVersion(interfaceVersion);
        }

        // 弱类型接口名
        reference.setInterface(interfaceName);
        reference.setId(interfaceName);
        reference.setProtocol("dubbo");
        reference.setRetries(0);


        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        return GenericServiceFactory.get(reference);
    }


    static class GenericServiceFactory {

        public static GenericService get(ReferenceConfig<GenericService> reference) {
            ReferenceConfigCache configCache = ReferenceConfigCache.getCache();
            return configCache.get(reference);
        }
    }

    static class RegistryConfigFactory {
        private static ConcurrentMap<String, RegistryConfig> zkAddressMap = new ConcurrentHashMap<>();

        public static RegistryConfig get(String zookeeperAddress) {
            if (StringUtils.isBlank(zookeeperAddress)) {
                return null;
            }

            RegistryConfig registryConfig = zkAddressMap.get(zookeeperAddress);

            if (registryConfig == null) {
                RegistryConfig registry = new RegistryConfig();
                registry.setAddress(zookeeperAddress);
                registry.setProtocol("zookeeper");
                registry.setCheck(false);
                zkAddressMap.putIfAbsent(zookeeperAddress, registry);
            }

            return zkAddressMap.get(zookeeperAddress);
        }
    }

}

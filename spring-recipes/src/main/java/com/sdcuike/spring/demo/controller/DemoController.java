package com.sdcuike.spring.demo.controller;

import com.sdcuike.spring.common.result.ModelResult;
import com.sdcuike.spring.demo.dao.ActorMapper;
import com.sdcuike.spring.demo.domain.ActorDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sdcuike
 * @date 2018/7/19
 * @since 2018/7/19
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    ActorMapper actorMapper;

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelResult<List<ActorDO>> test() {

        ActorDO actorDO = actorMapper.selectByPrimaryKey((short) 6);
        return new ModelResult<>().withData(actorDO);
    }

    @PostMapping("/test/dto")
    public ModelResult<String> test(@RequestBody DemoRequestDTO demoRequestDTO) {
        return new ModelResult<>().withData(demoRequestDTO.toString());

    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelResult<String> file(MultipartFile file) {
        StringBuilder sb = new StringBuilder();

        if (file == null) {
            return new ModelResult<>().withData(sb.toString());
        }

        sb.append("ContentType():").append(file.getContentType());
        sb.append("; Name:").append(file.getName());
        sb.append("; OriginalFilename:").append(file.getOriginalFilename());
        sb.append("; Size:").append(file.getSize());

        return new ModelResult<>().withData(sb.toString());
    }

    @PostMapping(value = "/form-post", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelResult<String> formPost(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        StringBuilder sb = new StringBuilder();
        sb.append("name:").append(name);
        sb.append(";age:").append(age);

        return new ModelResult<>().withData(sb.toString());

    }

    @Data
    @NoArgsConstructor
    public static class DemoRequestDTO {
        private Integer pageNo;
        private Integer pageSize;

        private RequestInfoDto requestInfoDto;

        private List<RequestInfoDto> others;


    }

    @Data
    @NoArgsConstructor
    public static class RequestInfoDto {
        private Integer id;
        private String address;

    }
}

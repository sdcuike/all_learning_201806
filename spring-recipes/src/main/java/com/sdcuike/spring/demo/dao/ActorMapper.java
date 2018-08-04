package com.sdcuike.spring.demo.dao;

import com.sdcuike.spring.demo.domain.ActorDO;

import java.util.List;

public interface ActorMapper {

    List<ActorDO> selectAll();

    int insert(ActorDO record);

    int insertSelective(ActorDO record);

    ActorDO selectByPrimaryKey(Short actorId);

    int updateByPrimaryKeySelective(ActorDO record);

    int updateByPrimaryKey(ActorDO record);
}
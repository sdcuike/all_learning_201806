package com.sdcuike.spring.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ActorDO {
    private Short actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;


}
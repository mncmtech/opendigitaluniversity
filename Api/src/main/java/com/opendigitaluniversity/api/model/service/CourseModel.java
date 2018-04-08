package com.opendigitaluniversity.api.model.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.api.common.entity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by sonudhakar on 23/07/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseModel extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 8103509625951224949L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type") //degree course | diploma course | other course
    private String type;

    @JsonProperty("typeId") // streamId
    private String typeId;

    @JsonProperty("duration") // 3 Years | 6 Month | other
    private String duration;

    @JsonProperty("description")
    private String description;

    @JsonProperty("linkedSubjects") // linkedSubjects
    private Set<String> linkedSubjects;
}

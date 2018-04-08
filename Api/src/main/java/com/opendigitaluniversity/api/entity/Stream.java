package com.opendigitaluniversity.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.objectify.annotation.*;
import com.api.common.enums.EntityStatus;
import com.api.common.entity.AbstractBaseEntity;
import com.opendigitaluniversity.api.model.service.StreamModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Set;

/**
 * Created by sonudhakar on 22/07/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class Stream extends AbstractBaseEntity{
    private static final long serialVersionUID = 7153754873084769277L;
    @Index
    private String name;

    @Index
    private String type;

    @Index
    private String description;

    @Unindex
    private EntityStatus status;

    @Unindex
    private Set<String> linkedCourses;


    public Stream(String name, String description, String type,Set<String> linkedCourses) {

        this.name = name;
        this.description = description;
        this.type = type;
        this.linkedCourses = linkedCourses;
    }

    public Stream(StreamModel streamModel){
        this.name = streamModel.getName();
        this.id = streamModel.getId();
        this.linkedCourses = streamModel.getLinkedCourses();
        this.description = streamModel.getDescription();
        this.type = streamModel.getType();
    }
}

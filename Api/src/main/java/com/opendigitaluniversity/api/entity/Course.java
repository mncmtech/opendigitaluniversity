package com.opendigitaluniversity.api.entity;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.api.common.enums.EntityStatus;
import com.api.common.entity.AbstractBaseEntity;
import com.opendigitaluniversity.api.model.service.CourseModel;
import com.opendigitaluniversity.api.model.service.StreamModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by sonudhakar on 23/07/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class Course extends AbstractBaseEntity{

    @Index
    private String name;

    @Unindex
    private String duration;

    @Index
    private String type;

    @Index
    private String typeId;

    @Unindex
    private EntityStatus status;

    @Unindex
    private String description;

    @Unindex
    private Set<String> linkedSubjects;


    public Course(String name, String description,String duration, String type,Set<String> linkedSubjects,String typeId) {

        this.name = name;
        this.description = description;
        this.type = type;
        this.linkedSubjects = linkedSubjects;
        this.duration = duration;
        this.typeId = typeId;
    }

    public Course(CourseModel courseModel){
        this.name = courseModel.getName();
        this.id = courseModel.getId();
        this.linkedSubjects = courseModel.getLinkedSubjects();
        this.description = courseModel.getDescription();
        this.type = courseModel.getType();
        this.duration = courseModel.getDuration();
        this.typeId = courseModel.getTypeId();
    }

}

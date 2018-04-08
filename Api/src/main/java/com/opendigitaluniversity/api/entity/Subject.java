package com.opendigitaluniversity.api.entity;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.api.common.enums.EntityStatus;
import com.api.common.entity.AbstractBaseEntity;
import com.opendigitaluniversity.api.model.service.SubjectModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class Subject extends AbstractBaseEntity{

    private static final long serialVersionUID = 7153754873084769277L;
    @Index
    private String name;

    @Unindex
    private String description;

    @Unindex
    private EntityStatus status;


    public Subject(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public Subject(SubjectModel subjectModel){
        this.name = subjectModel.getName();
        this.id = subjectModel.getId();
        this.description = subjectModel.getDescription();
    }
}

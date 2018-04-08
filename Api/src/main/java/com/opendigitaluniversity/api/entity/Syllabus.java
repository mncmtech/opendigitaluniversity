package com.opendigitaluniversity.api.entity;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.api.common.enums.EntityStatus;
import com.api.common.entity.AbstractBaseEntity;
import com.opendigitaluniversity.api.model.service.SyllabusModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class Syllabus extends AbstractBaseEntity{

    private static final long serialVersionUID = 7153754873084769277L;
    @Index
    private String subjectId;

    @Unindex
    private String description;

    @Unindex
    private String filePath;

    @Unindex
    private EntityStatus status;


    public Syllabus(String subjectId, String description,String filePath) {

        this.subjectId = subjectId;
        this.description = description;
        this.filePath = filePath;

    }

    public Syllabus(SyllabusModel syllabusModel){
        this.subjectId = syllabusModel.getSubjectId();
        this.id = syllabusModel.getId();
        this.description = syllabusModel.getDescription();
        this.filePath = syllabusModel.getFilePath();
    }
}

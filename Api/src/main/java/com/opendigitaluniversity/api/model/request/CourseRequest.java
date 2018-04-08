package com.opendigitaluniversity.api.model.request;

import lombok.Data;

import java.util.Set;

/**
 * Created by sonudhakar on 23/07/17.
 */
@Data
public class CourseRequest {

    private String id;

    private String name;

    private String type;

    private String typeId;

    private String description;

    private String duration;

    private Set<String> linkedSubjects;
}

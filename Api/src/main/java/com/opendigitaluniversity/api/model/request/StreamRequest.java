package com.opendigitaluniversity.api.model.request;

import lombok.Data;

import java.util.Set;

/**
 * Created by sonudhakar on 23/07/17.
 */
@Data
public class StreamRequest {

    private String id;

    private String name;

    private String type;

    private String description;

    private Set<String> linkedSubjects;

}

package com.opendigitaluniversity.api.model.request;

import lombok.Data;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Data
public class SyllabusRequest {

    private String id;

    private String description;

    private String subjectId;

    private String filePath;

}

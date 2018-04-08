package com.opendigitaluniversity.api.dao;

import com.opendigitaluniversity.api.entity.Syllabus;
import com.opendigitaluniversity.api.model.request.SyllabusRequest;

/**
 * Created by sonudhakar on 29/07/17.
 */
public interface SyllabusDao {

    Syllabus get(String id);
    Syllabus getByName(String name) throws Exception;
    Syllabus createNewSyllabus(SyllabusRequest subjectRequest) throws Exception;
    Syllabus saveSyllabus(Syllabus subject) throws Exception;
    Syllabus delete(String  subjectId) throws Exception;
}

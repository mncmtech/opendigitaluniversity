package com.opendigitaluniversity.api.dao;

import com.opendigitaluniversity.api.entity.Subject;
import com.opendigitaluniversity.api.model.request.SubjectRequest;

/**
 * Created by sonudhakar on 29/07/17.
 */
public interface SubjectDao {

    Subject get(String id);
    Subject getByName(String name) throws Exception;
    Subject createNewSubject(SubjectRequest subjectRequest) throws Exception;
    Subject saveSubject(Subject subject) throws Exception;
    Subject delete(String  subjectId) throws Exception;
}

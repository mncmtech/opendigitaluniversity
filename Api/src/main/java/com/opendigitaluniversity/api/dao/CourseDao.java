package com.opendigitaluniversity.api.dao;

import com.opendigitaluniversity.api.entity.Course;
import com.opendigitaluniversity.api.model.request.CourseRequest;

/**
 * Created by sonudhakar on 23/07/17.
 */
public interface CourseDao {

    Course createNewCourse(CourseRequest courseRequest) throws Exception;
    Course getByName(String courseName) throws Exception;
    Course get(String courseId);
    Course saveCourse(Course course);
    Course deleteCourse(String id);
}

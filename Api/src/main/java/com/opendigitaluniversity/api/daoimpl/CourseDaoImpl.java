package com.opendigitaluniversity.api.daoimpl;

import com.opendigitaluniversity.api.dao.CourseDao;
import com.opendigitaluniversity.api.entity.Course;
import com.api.common.enums.EntityStatus;
import com.opendigitaluniversity.api.model.request.CourseRequest;
import com.opendigitaluniversity.api.model.service.CourseModel;
import com.api.common.services.objectify.OfyService;
import com.api.common.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sonudhakar on 23/07/17.
 */
@Slf4j
public class CourseDaoImpl extends OfyService implements CourseDao{

    @Override
    public Course get(String courseId){
        return get(Course.class,courseId);
    }

    @Override
    public Course getByName(String courseName) throws Exception{
        if (courseName == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Course.class).filter("name", courseName).first().now();
    }

    @Override
    public Course createNewCourse(CourseRequest courseRequest) throws Exception{

        CourseModel courseModel = new CourseModel();
        courseModel.setDescription(courseRequest.getDescription());
        courseModel.setType(courseRequest.getType());
        courseModel.setName(courseRequest.getName());
        courseModel.setLinkedSubjects(courseRequest.getLinkedSubjects());
        courseModel.setDuration(courseRequest.getDuration());

        if(courseRequest.getId() != null){
            courseModel.setId(courseRequest.getId());
        }else{
            courseModel.setId(RandomUtil.generateSecureRandomString(32,RandomUtil.RandomModeType.ALPHANUMERIC));
        }
        Course course = new Course(courseModel);
        course.setStatus(EntityStatus.ACTIVE);

        return saveCourse(course);

    }

    @Override
    public  Course saveCourse(Course course){

        return save(course) != null ? course : null;

    }

    @Override
    public  Course deleteCourse(String id){

        Course course = get(id);

        if(course == null)
            return null;

        return delete(course) ? course : null;

    }
}

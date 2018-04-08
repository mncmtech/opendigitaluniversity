package com.opendigitaluniversity.api.endpoints.api;

import com.opendigitaluniversity.api.constants.Constant;
import com.opendigitaluniversity.api.dao.CourseDao;
import com.opendigitaluniversity.api.daoimpl.CourseDaoImpl;
import com.opendigitaluniversity.api.entity.Course;
import com.opendigitaluniversity.api.model.request.CourseRequest;
import com.opendigitaluniversity.api.model.response.ApiResponse;
import com.api.common.utils.ObjUtil;
import com.api.common.utils.Preconditions;
import com.opendigitaluniversity.api.validator.CourseRequestValidator;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * OpenDigitalUniversity
 * Created by sonudhakar on 23/07/17.
 */
@Slf4j
@Path("/v1/courses")
@Consumes(Constant.JSON_CONTENTTYPE)
public class CourseEndPoint {

    private final CourseDao courseDao = new CourseDaoImpl();
    private final CourseRequestValidator courseRequestValidator = new CourseRequestValidator();

    @GET
    @Path("/course/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourse(@PathParam("id") String id){

        ApiResponse apiResponse = new ApiResponse();
        Preconditions.checkArgument(ObjUtil.isBlank(id), "Invalid courseId");
        try{
            Course course = courseDao.get(id);
            if(course != null) {
                apiResponse.setOk(true);
                apiResponse.add("course", course);
            }else{
                apiResponse.setOk(false);
                apiResponse.add("msg","Course Not Found");
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return Response.ok(apiResponse).build();
    }

    @GET
    @Path("/course/{name}/getByName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseByName(@PathParam("name") String name){

        ApiResponse apiResponse = new ApiResponse();
        Preconditions.checkArgument(ObjUtil.isBlank(name), "Invalid Course Name");
        try{
            Course course = courseDao.getByName(name);
            if(course != null) {
                apiResponse.setOk(true);
                apiResponse.add("course", course);
            }else{
                apiResponse.setOk(false);
                apiResponse.add("msg","Course Not Found");
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return Response.ok(apiResponse).build();
    }

    @POST
    @Path("/course/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCourse(CourseRequest courseRequest) {
        ApiResponse apiResponse = new ApiResponse();

        courseRequestValidator.validate(courseRequest);
        try{
            Course course = courseDao.createNewCourse(courseRequest);
            if(course != null) {
                apiResponse.setOk(true);
                apiResponse.add("course", course);
            }else{
                apiResponse.setOk(false);
                apiResponse.add("msg","Course Not Saved");
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }

        return  Response.ok(apiResponse).build();
    }

    @DELETE
    @Path("/course/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(@PathParam("id") String id) {
        ApiResponse apiResponse = new ApiResponse();

        try{
            Course course = courseDao.deleteCourse(id);
            if(course != null) {
                apiResponse.setOk(true);
                apiResponse.add("course", course);
            }else{
                apiResponse.setOk(false);
                apiResponse.add("msg","Course Not Deleted");
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }

        return  Response.ok(apiResponse).build();
    }
}

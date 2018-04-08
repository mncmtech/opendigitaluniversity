package com.opendigitaluniversity.api.endpoints.api;

import com.opendigitaluniversity.api.constants.Constant;
import com.opendigitaluniversity.api.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * OpenDigitalUniversity
 * Created by sonudhakar on 29/07/17.
 */
@Slf4j
@Path("/v1/subjects")
@Consumes(Constant.JSON_CONTENTTYPE)
public class SubjectEndPoint {

    @Path("/subject/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubject(){
        ApiResponse apiResponse = new ApiResponse();
        try{
            apiResponse.setOk(true);


        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return Response.ok(apiResponse).build();
    }

}

package com.opendigitaluniversity.api.exception.mapper;

import com.api.common.enums.ApiErrorCode;
import com.opendigitaluniversity.api.model.response.ApiResponse;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * OpenDigitalUniversity
 * Created by sonudhakar on 23/07/17.
 */
public class JaxRsForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException e) {
        ApiResponse resp = new ApiResponse(false, ApiErrorCode.FORBIDDEN_REQUEST, e.getMessage() == null ? "you are not authorized for this action" : e.getMessage());
        return Response.status(Response.Status.FORBIDDEN).entity(resp).type(MediaType.APPLICATION_JSON).build();
    }
}

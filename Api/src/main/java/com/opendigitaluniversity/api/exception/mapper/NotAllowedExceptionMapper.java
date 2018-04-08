package com.opendigitaluniversity.api.exception.mapper;

import com.opendigitaluniversity.api.constants.Constant;
import com.api.common.enums.ApiErrorCode;
import com.opendigitaluniversity.api.model.response.ApiResponse;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * OpenDigitalUniversity
 * Created by sonudhakar on 23/07/17.
 */
public class NotAllowedExceptionMapper implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException e) {

        ApiResponse response = new ApiResponse(false, ApiErrorCode.METHOD_NOT_ALLOWED, e.getMessage() != null ? e.getMessage() : "the requested method is not allowed for the endpoint");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).type(Constant.JSON_CONTENTTYPE).entity(response).build();
    }
}

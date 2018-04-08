package com.opendigitaluniversity.api.exception.mapper;

import com.opendigitaluniversity.api.constants.Constant;
import com.api.common.enums.ApiErrorCode;
import com.opendigitaluniversity.api.model.response.ApiResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * OpenDigitalUniversity
 * Created by sonudhakar on 23/07/17.
 */
public class InvalidFormatExceptionMapper implements ExceptionMapper<InvalidFormatException> {

    @Override
    public Response toResponse(InvalidFormatException exception) {

        ApiResponse response = new ApiResponse(false, ApiErrorCode.BAD_REQUEST, "invalid format, please check the json property value");

        return Response.status(Response.Status.BAD_REQUEST).type(Constant.JSON_CONTENTTYPE).entity(response).build();
    }
}

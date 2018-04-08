package com.opendigitaluniversity.api.endpoints.api;

import com.opendigitaluniversity.api.constants.Constant;
import com.opendigitaluniversity.api.dao.StreamsDao;
import com.opendigitaluniversity.api.daoimpl.StreamsDaoImpl;
import com.opendigitaluniversity.api.entity.Stream;
import com.api.common.enums.ErrorCode;
import com.api.common.exception.EntityException;
import com.opendigitaluniversity.api.model.response.ApiResponse;
import com.api.common.utils.ObjUtil;
import com.api.common.utils.Preconditions;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.opendigitaluniversity.api.model.request.StreamRequest;
import com.opendigitaluniversity.api.validator.StreamRequestValidator;

/**
 * Created by sonudhakar on 17/07/17.
 */
@Slf4j
@Path("/v1/streams")
@Consumes(Constant.JSON_CONTENTTYPE)
public class StreamsEndPoint {

    private final StreamsDao streamsDao = new StreamsDaoImpl();
    private final StreamRequestValidator streamRequestValidator = new StreamRequestValidator();

    @GET
    @Path("/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStreamById(@PathParam("id") String id) {
        ApiResponse apiResponse = new ApiResponse();

        Preconditions.checkArgument(ObjUtil.isBlank(id), "Invalid streamId");

        Stream stream = streamsDao.get(id);

        if(stream != null) {
            apiResponse.setOk(true);
            apiResponse.add("stream", stream);
        }else{
            apiResponse.setOk(false);
            apiResponse.add("msg","Stream Not Found");
        }
        return  Response.ok(apiResponse).build();
    }

    @POST
    @Path("/stream/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveStream(StreamRequest streamRequest) {
        ApiResponse apiResponse = new ApiResponse();

        streamRequestValidator.validate(streamRequest);
        try{
            Stream stream = streamsDao.createNewStream(streamRequest);
            if(stream != null) {
                apiResponse.setOk(true);
                apiResponse.add("stream", stream);
            }else{
                apiResponse.setOk(false);
                apiResponse.add("msg","Stream Not Saved");
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }

        return  Response.ok(apiResponse).build();
    }
}

package com.opendigitaluniversity.api.validator;

import com.opendigitaluniversity.api.model.request.StreamRequest;
import com.opendigitaluniversity.api.utils.ObjUtil;
import com.opendigitaluniversity.api.utils.Preconditions;

/**
 * Created by sonudhakar on 23/07/17.
 */
public class StreamRequestValidator {

    public void validate(StreamRequest streamRequest){
        Preconditions.checkArgument(streamRequest == null, "Invalid Request");
        Preconditions.checkArgument(ObjUtil.isBlank(streamRequest.getName()), "Invalid Stream Name");
        Preconditions.checkArgument(ObjUtil.isBlank(streamRequest.getType()), "Invalid Stream Type");
    }
}

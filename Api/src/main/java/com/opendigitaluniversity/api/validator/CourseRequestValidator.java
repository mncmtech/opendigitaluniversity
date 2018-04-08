package com.opendigitaluniversity.api.validator;

import com.opendigitaluniversity.api.model.request.CourseRequest;
import com.opendigitaluniversity.api.model.request.StreamRequest;
import com.opendigitaluniversity.api.utils.ObjUtil;
import com.opendigitaluniversity.api.utils.Preconditions;

/**
 * Created by sonudhakar on 23/07/17.
 */
public class CourseRequestValidator {

    public void validate(CourseRequest courseRequest){

        Preconditions.checkArgument(courseRequest == null, "Invalid Request");
        Preconditions.checkArgument(ObjUtil.isBlank(courseRequest.getName()), "Invalid Stream Name");
        Preconditions.checkArgument(ObjUtil.isBlank(courseRequest.getType()), "Invalid Stream Type");
        Preconditions.checkArgument(ObjUtil.isBlank(courseRequest.getDescription()), "Invalid Stream Type");
        Preconditions.checkArgument(ObjUtil.isBlank(courseRequest.getDuration()), "Invalid Stream Type");
    }
}

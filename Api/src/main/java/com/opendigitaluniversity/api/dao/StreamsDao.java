package com.opendigitaluniversity.api.dao;

import com.opendigitaluniversity.api.entity.Stream;
import com.opendigitaluniversity.api.model.request.StreamRequest;

/**
 * Created by sonudhakar on 22/07/17.
 */
public interface StreamsDao {

    Stream get(String id);
    Stream getByName(String name) throws Exception;
    Stream saveStream(Stream stream) throws Exception;
    Stream delete(String  streamId) throws Exception;
    Stream createNewStream(StreamRequest streamRequest) throws Exception;
}

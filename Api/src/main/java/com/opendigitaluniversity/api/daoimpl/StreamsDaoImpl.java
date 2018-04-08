package com.opendigitaluniversity.api.daoimpl;

import com.googlecode.objectify.Objectify;
import com.opendigitaluniversity.api.dao.StreamsDao;
import com.opendigitaluniversity.api.entity.Stream;
import com.api.common.enums.EntityStatus;
import com.opendigitaluniversity.api.model.request.StreamRequest;
import com.opendigitaluniversity.api.model.service.StreamModel;
import com.api.common.services.objectify.OfyService;
import com.api.common.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sonudhakar on 22/07/17.
 */
@Slf4j
public class StreamsDaoImpl extends OfyService implements StreamsDao{

    @Override
    public Stream get(String id) {
        return get(Stream.class,id);
    }

    @Override
    public Stream getByName(String name) throws Exception{

        if (name == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Stream.class).filter("name", name).first().now();
    }

    @Override
    public Stream createNewStream(StreamRequest streamRequest) throws Exception{

        StreamModel streamModel = new StreamModel();
        streamModel.setName(streamRequest.getName());
        streamModel.setDescription(streamRequest.getDescription());
        streamModel.setType(streamRequest.getType());
        if(streamRequest.getId() != null) {
            streamModel.setId(streamRequest.getId());
        }else{
            streamModel.setId(RandomUtil.generateSecureRandomString(32, RandomUtil.RandomModeType.ALPHANUMERIC));
        }
        Stream stream = new Stream(streamModel);
        stream.setStatus(EntityStatus.ACTIVE);
        return saveStream(stream);

    }
    @Override
    public Stream saveStream(Stream stream) throws Exception{
        stream.updateTimeStamps();
        return save(stream) == null ? null : stream;
    }

    @Override
    public Stream delete(String  streamId) throws Exception{

        Stream stream = get(streamId);
        return delete(stream) ? stream : null;

    }

}

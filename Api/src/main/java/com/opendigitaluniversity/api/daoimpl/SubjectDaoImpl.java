package com.opendigitaluniversity.api.daoimpl;

import com.opendigitaluniversity.api.dao.StreamsDao;
import com.opendigitaluniversity.api.dao.SubjectDao;
import com.opendigitaluniversity.api.entity.Stream;
import com.opendigitaluniversity.api.entity.Subject;
import com.api.common.enums.EntityStatus;
import com.opendigitaluniversity.api.model.request.StreamRequest;
import com.opendigitaluniversity.api.model.request.SubjectRequest;
import com.opendigitaluniversity.api.model.service.StreamModel;
import com.opendigitaluniversity.api.model.service.SubjectModel;
import com.api.common.services.objectify.OfyService;
import com.api.common.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Slf4j
public class SubjectDaoImpl extends OfyService implements SubjectDao {

    @Override
    public Subject get(String id) {
        return get(Subject.class,id);
    }

    @Override
    public Subject getByName(String name) throws Exception{

        if (name == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Subject.class).filter("name", name).first().now();
    }

    @Override
    public Subject createNewSubject(SubjectRequest subjectRequest) throws Exception{

        SubjectModel subjectModel = new SubjectModel();
        subjectModel.setName(subjectRequest.getName());
        subjectModel.setDescription(subjectRequest.getDescription());
        if(subjectRequest.getId() != null) {
            subjectModel.setId(subjectRequest.getId());
        }else{
            subjectModel.setId(RandomUtil.generateSecureRandomString(32, RandomUtil.RandomModeType.ALPHANUMERIC));
        }
        Subject subject = new Subject(subjectModel);
        subject.setStatus(EntityStatus.ACTIVE);
        return saveSubject(subject);

    }
    @Override
    public Subject saveSubject(Subject subject) throws Exception{
        subject.updateTimeStamps();
        return save(subject) == null ? null : subject;
    }

    @Override
    public Subject delete(String  subjectId) throws Exception{

        Subject subject = get(subjectId);
        return delete(subject) ? subject : null;

    }

}

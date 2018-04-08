package com.opendigitaluniversity.api.daoimpl;

import com.opendigitaluniversity.api.dao.SyllabusDao;
import com.opendigitaluniversity.api.entity.Syllabus;
import com.opendigitaluniversity.api.model.request.SyllabusRequest;
import com.opendigitaluniversity.api.model.service.SyllabusModel;
import com.api.common.services.objectify.OfyService;
import lombok.extern.slf4j.Slf4j;
import com.api.common.utils.RandomUtil;
import com.api.common.enums.EntityStatus;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Slf4j
public class SyllabusDaoImpl extends OfyService implements SyllabusDao{

    @Override
    public Syllabus get(String id) {
        return get(Syllabus.class,id);
    }

    @Override
    public Syllabus getByName(String name) throws Exception{

        if (name == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Syllabus.class).filter("name", name).first().now();
    }

    @Override
    public Syllabus createNewSyllabus(SyllabusRequest syllabusRequest) throws Exception{

        SyllabusModel syllabusModel = new SyllabusModel();
        syllabusModel.setDescription(syllabusRequest.getDescription());
        if(syllabusRequest.getId() != null) {
            syllabusModel.setId(syllabusRequest.getId());
        }else{
            syllabusModel.setId(RandomUtil.generateSecureRandomString(32, RandomUtil.RandomModeType.ALPHANUMERIC));
        }
        Syllabus subject = new Syllabus(syllabusModel);
        subject.setStatus(EntityStatus.ACTIVE);
        return saveSyllabus(subject);

    }

    @Override
    public Syllabus saveSyllabus(Syllabus syllabus) throws Exception{
        syllabus.updateTimeStamps();
        return save(syllabus) == null ? null : syllabus;
    }

    @Override
    public Syllabus delete(String  subjectId) throws Exception{

        Syllabus syllabus = get(subjectId);
        return delete(syllabus) ? syllabus : null;

    }

}

package com.opendigitaluniversity.api.config;

import com.opendigitaluniversity.api.endpoints.api.StreamsEndPoint;
import com.api.common.services.objectify.OfyService;
import com.opendigitaluniversity.api.entity.Stream;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import com.opendigitaluniversity.api.filter.ApiLoggingFilter;
import com.opendigitaluniversity.api.filter.CommonApiResponseFilter;
import com.googlecode.objectify.util.jackson.ObjectifyJacksonModule;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import com.opendigitaluniversity.api.exception.mapper.ForbiddenExceptionMapper;
import com.opendigitaluniversity.api.exception.mapper.GenericExceptionMapper;
import com.opendigitaluniversity.api.exception.mapper.IllegalArgExceptionMapper;
import com.opendigitaluniversity.api.exception.mapper.InvalidFormatExceptionMapper;
import com.opendigitaluniversity.api.exception.mapper.JaxRsForbiddenExceptionMapper;
import com.opendigitaluniversity.api.exception.mapper.NotAllowedExceptionMapper;
import com.opendigitaluniversity.api.exception.mapper.ResourceNotFoundExceptionMapper;

/**
 * Created by sonudhakar on 16/07/17.
 */
public class AppConfig extends Application {

    public AppConfig() {
        registerOfyEntities();
    }

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        classes.add(JacksonObjectResolver.class);
        classes.add(ObjectifyJacksonModule.class);

        registerApis(classes);

        return classes;
    }

    @Override
    public Set<Object> getSingletons() {

        Set<Object> singletons = new HashSet<>();
        singletons.add(new ApiLoggingFilter());
        singletons.add(new CommonApiResponseFilter());

        //exception mappers
        singletons.add(new IllegalArgExceptionMapper());
        singletons.add(new ResourceNotFoundExceptionMapper());
        singletons.add(new ForbiddenExceptionMapper());
        singletons.add(new NotAllowedExceptionMapper());
        singletons.add(new JaxRsForbiddenExceptionMapper());
        singletons.add(new InvalidFormatExceptionMapper());
        singletons.add(new GenericExceptionMapper());

        // for now allowing all based on requested origins
        CorsFilter cors = new CorsFilter();
        cors.getAllowedOrigins().add("*");
        cors.setCorsMaxAge(1728000);
        cors.setAllowCredentials(false);

        singletons.add(cors);
        return singletons;
    }

    private void registerApis(Set<Class<?>> classes) {
        //TODO : register all api endpoints
        classes.add(StreamsEndPoint.class);
    }


    private void registerOfyEntities() {

        //TODO : Register all persistable entity JDO

        OfyService.factory().register(Stream.class);
    }
}

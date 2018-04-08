package com.opendigitaluniversity.api.entity;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.api.common.enums.ContactMethodType;
import com.opendigitaluniversity.api.model.service.ContactMethodModel;
import com.api.common.entity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class ContactMethod extends AbstractBaseEntity{

    @Unindex
    private String key;

    @Unindex
    private String value;

    @Unindex
    private ContactMethodType type;

    @Unindex
    private Boolean primary;


    public ContactMethod(ContactMethodModel contactMethodModel){

        this.key = contactMethodModel.getKey();
        this.value = contactMethodModel.getValue();
        this.type = contactMethodModel.getType();
        this.primary = contactMethodModel.getPrimary();
        this.id = contactMethodModel.getId();

    }
}

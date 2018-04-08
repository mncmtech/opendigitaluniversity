package com.opendigitaluniversity.api.entity;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.api.common.enums.AddressType;
import com.opendigitaluniversity.api.model.service.AddressModel;
import com.api.common.entity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class Address extends AbstractBaseEntity{

    @Unindex
    private String homeNumber;

    @Unindex
    private String street;

    @Unindex
    private String city;

    @Unindex
    private String region;

    @Unindex
    private String country;

    @Unindex
    private int postcode;

    @Unindex
    private AddressType type;

    @Unindex
    private Boolean primary;


    public Address(AddressModel addressModel){
        this.homeNumber = addressModel.getHomeNumber();
        this.street = addressModel.getStreet();
        this.city = addressModel.getCity();
        this.region = addressModel.getRegion();
        this.country = addressModel.getCountry();
        this.postcode = addressModel.getPostcode();
        this.primary = addressModel.getPrimary();
        this.type = addressModel.getType();

    }
}

package com.opendigitaluniversity.api.model.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.api.common.entity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import com.api.common.enums.AddressType;
import java.util.Set;

/**
 * Created by sonudhakar on 29/07/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AddressModel extends AbstractBaseEntity implements Serializable{

    private static final long serialVersionUID = 8103509625951224949L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("homeNumber")
    private String homeNumber;

    @JsonProperty("street") //degree course | diploma course | other course
    private String street;

    @JsonProperty("city") // streamId
    private String city;

    @JsonProperty("region") // 3 Years | 6 Month | other
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("postcode") // linkedSubjects
    private int postcode;

    @JsonProperty("primary")
    private Boolean primary;

    @JsonProperty("type")
    private AddressType type;
}

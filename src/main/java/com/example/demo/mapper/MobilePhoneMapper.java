package com.example.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.controller.dto.MobilePhoneDto;
import com.example.demo.entites.MobilePhone;

@Mapper
public interface MobilePhoneMapper {
	    @Mapping(target="color",source="mobilePhone.color")
	    @Mapping(target="brandName",source="mobilePhone.brandName")
		public MobilePhoneDto convertToDto(MobilePhone mobilePhone);
	    
	    @Mapping(target="color", source="color") 
	    @Mapping(target="brandName", source="brandName") 
	    public MobilePhone convertToEntity(MobilePhoneDto dto);
}

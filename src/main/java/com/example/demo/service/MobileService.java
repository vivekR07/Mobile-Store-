package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.dto.MobilePhoneDto;
import com.example.demo.entites.MobilePhone;
import com.example.demo.entites.MobilePhoneList;
import com.example.demo.exception.MobilePhonesNotFoundException;

public interface MobileService {
	public List<MobilePhone> getAllMobiles() throws MobilePhonesNotFoundException;

	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhonesNotFoundException;

	public MobilePhone getMobilePhoneById2(int id) throws MobilePhonesNotFoundException; 

	public MobilePhone getMobilePhoneByBrandName1(String brandName) throws MobilePhonesNotFoundException;

	public MobilePhone getMobilePhoneByModelName1(String modelName) throws MobilePhonesNotFoundException;

	public MobilePhone editMobilephone(MobilePhone mobilePhone) throws MobilePhonesNotFoundException;

	public String deleteMobilePhone(int id) throws MobilePhonesNotFoundException;

    public List<MobilePhoneDto> getAllMobilePhones() throws MobilePhonesNotFoundException;

    public MobilePhoneDto getMobilePhoneById(int id) throws MobilePhonesNotFoundException;
    
	public List<MobilePhoneDto> getMobilePhoneByBrandName(String brandName) throws MobilePhonesNotFoundException;

	//public List<MobilePhoneDto> getMobilePhoneByModelName(String modelName);

	public int getMobilePhone(double cost) throws MobilePhonesNotFoundException; // get total number of mobile phones who having cost > 10K

	public List<MobilePhone> getByProcessor(String processor) throws MobilePhonesNotFoundException; // get Mobile Phone whose having processor with name -
																// Quad Core

	public List<MobilePhone> getByColor(String name) throws MobilePhonesNotFoundException; // get Mobile Phone whose having color - black and blue

	public int getMobilePhones(); // get total number of mobile phone who are having unique model names

	public MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long MobilePhoneListId); // adding mobilePhone to
																								// MobilePhoneList

}

package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MobileRepository;
import com.example.demo.controller.dto.MobilePhoneDto;
import com.example.demo.entites.MobilePhone;
import com.example.demo.entites.MobilePhoneList;
import com.example.demo.exception.MobilePhonesNotFoundException;
import com.example.demo.mapper.MobilePhoneMapper;
import com.example.demo.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepository mobileRepo;

	@Autowired
	private MobilePhoneMapper MobileMapper;

	@Override
	public List<MobilePhone> getAllMobiles() throws MobilePhonesNotFoundException {
		List<MobilePhone> phones = mobileRepo.getMobileDetails();
		if (phones.isEmpty()) {
			throw new MobilePhonesNotFoundException("the mobile list is empty please add it");
		}
		return phones;
	}
	@Override
	public int getMobilePhones() {
		int  phones=mobileRepo.getUniqueModelName();
		
		return phones;
	}
	@Override
	public int getMobilePhone(double cost) throws MobilePhonesNotFoundException {
		int phone=mobileRepo.getMobileWithTenk(cost);
		if(phone==0)
		{
			throw new MobilePhonesNotFoundException("mobile with that processor not exist");
		}
		return phone;
	}

	
	@Override
	public List<MobilePhone> getByProcessor(String name) throws MobilePhonesNotFoundException {
		List<MobilePhone> phone=mobileRepo.getMobileProcessorWithSameName(name);
		if(phone.isEmpty()) {
			throw new MobilePhonesNotFoundException("mobile with that processor not exist");
		}
		return phone;
	}
	
	@Override
	public List<MobilePhone> getByColor(String name) throws MobilePhonesNotFoundException {
		List<MobilePhone> phone=mobileRepo.getMobileWithSameColor(name);
		if(phone.isEmpty()) {
			throw new MobilePhonesNotFoundException("mobile with that color not exist");
		}
		return phone;
	}

	@Override
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhonesNotFoundException {
		MobilePhone mobile = null;
		if (mobileRepo.existsById(mobilePhone.getMobileId())) {
			throw new MobilePhonesNotFoundException("mobile already exist with that id");
		} else {
			mobile = mobileRepo.saveAndFlush(mobilePhone);
		}
		return mobile;
	}

	@Override
	public MobilePhone getMobilePhoneByModelName1(String modelName) throws MobilePhonesNotFoundException {
		MobilePhone mobile = mobileRepo.getMobilePhoneByModelName1(modelName);
		if (mobile == null) {
			throw new MobilePhonesNotFoundException("mobile not exist with that id");
		}
		return mobile;
	}

	@Override
	public MobilePhone editMobilephone(MobilePhone mobilePhone) throws MobilePhonesNotFoundException {
		MobilePhone mobile = mobileRepo.findById(mobilePhone.getMobileId()).get();
		if (mobileRepo.existsById(mobilePhone.getMobileId())) {
			mobile.setBatteryPower(mobilePhone.getBatteryPower());
			mobile.setBrandName(mobilePhone.getBrandName());
			mobile.setColor(mobilePhone.getColor());
			mobile.setMobilePhoneCost(mobilePhone.getMobilePhoneCost());
			mobile.setModelName(mobilePhone.getModelName());
			mobile.setProcessor(mobilePhone.getProcessor());
			mobileRepo.save(mobile);
		} else {
			if (mobile == null)
				throw new MobilePhonesNotFoundException("mobilePhone not exist with that id");
		}
		return mobile;
	}

	@Override
	public String deleteMobilePhone(int id) throws MobilePhonesNotFoundException {
		MobilePhone mobile = mobileRepo.findById(id).get();
		if (mobile.getMobileId() == id) {
			mobileRepo.deleteById(id);
		} else {
			throw new MobilePhonesNotFoundException("mobile with that id not exist");
		}
		return "product deleted";
	}


	@Override
	public MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long MobilePhoneListId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MobilePhone getMobilePhoneById2(int id) throws MobilePhonesNotFoundException {
		MobilePhone mobile = mobileRepo.getMobilePhoneById2(id);
		if (mobile == null) {
			throw new MobilePhonesNotFoundException("mobile not exist with that id");
		}
		return mobile;
	}

	@Override
	public MobilePhoneDto getMobilePhoneById(int id) throws MobilePhonesNotFoundException {
		List<MobilePhone> mobilePhone = mobileRepo.findAll();
		
		for (MobilePhone mobile : mobilePhone) {
			if (mobile.getMobileId() == (id))
				return MobileMapper.convertToDto(mobile);
		}
		if (mobilePhone.isEmpty()) {
			throw new MobilePhonesNotFoundException("mobilephone is not found");
		}
		return null;
	
	}

	@Override
	public MobilePhone getMobilePhoneByBrandName1(String brandName) throws MobilePhonesNotFoundException {
		MobilePhone name = mobileRepo.getMobilePhoneByBrandName1(brandName);
		if (name == null) {
			throw new MobilePhonesNotFoundException("mobile not exist with that brandname");
		}
		return name;
	}

	@Override
	public List<MobilePhoneDto> getAllMobilePhones() throws MobilePhonesNotFoundException {
		List<MobilePhone> mobiles = mobileRepo.findAll();
		MobilePhoneDto mdto = new MobilePhoneDto();
		List<MobilePhoneDto> mdtos = new ArrayList<>();
		for (MobilePhone m : mobiles) {
			mdto = MobileMapper.convertToDto(m);
			mdtos.add(mdto);
		}
		if (mobiles == null) {
			throw new MobilePhonesNotFoundException("mobiles are not found");
		}
		return mdtos;

	}

	@Override
	public List<MobilePhoneDto> getMobilePhoneByBrandName(String brandName) throws MobilePhonesNotFoundException {
	    List<MobilePhone> mobiles=mobileRepo.getMobilePhoneByBrandName(brandName);
	    if(mobiles.isEmpty()) {
	    	throw new MobilePhonesNotFoundException("mobiles with that brand name does not exist");
	    }
	    else {
	    	List<MobilePhoneDto> dtos=new ArrayList<MobilePhoneDto>();
	    	MobilePhoneDto dto=new MobilePhoneDto();
	    	for(MobilePhone mobile:mobiles) {
	    		dto=MobileMapper.convertToDto(mobile);
	    		dtos.add(dto);
	    	}
	    	return dtos;
	    }
		
	}

}

package com.example.demo.Repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.dto.MobilePhoneDto;
import com.example.demo.entites.MobilePhone;

@Repository
public interface MobileRepository extends JpaRepository<MobilePhone, Integer>{
    
	@Query(value="select m from MobilePhone m")
	public List<MobilePhone> getMobileDetails();
	
	//to get num  unique model name
	@Query(value="select m from MobilePhone m")
	public int getUniqueModelName();
	
	@Query(value="select m from MobilePhone m where m.mobileId=:id")
	public MobilePhone getMobilePhoneById2(@PathParam(value="id")int id);
	
//	@Query(value="select m from MobilePhoneDto m where m.mobileId=:id")  getMobileProcessorWithSameName
//	public MobilePhone getMobilePhoneById(@PathParam(value="id")int id);  getMobileWithSameColor
	
	@Query(value="select m from MobilePhone m where m.processor=:name")
	public List<MobilePhone> getMobileProcessorWithSameName(@PathParam(value="name")String name);
	
	//Color black and blue
	@Query(value="select m from MobilePhone m where m.color=:name")
	public List<MobilePhone> getMobileWithSameColor(@PathParam(value="name")String name);
	
	@Query(value="select m from MobilePhone m where m.brandName=:name")
	public MobilePhone getMobilePhoneByBrandName1(@PathParam(value="name")String name);
	
	@Query(value="select m from MobilePhone m where m.brandName=:name") //
	public List<MobilePhone> getMobilePhoneByBrandName(@PathParam(value="name")String name);
	
	@Query(value="select m from MobilePhone m where m.modelName=:name")
	public MobilePhone getMobilePhoneByModelName1(@PathParam(value="name")String name);
	
	@Query(value="select count(m) from MobilePhone m where m.mobilePhoneCost>:cost")
	public int getMobileWithTenk(@PathParam(value="cost")double cost);
	
}

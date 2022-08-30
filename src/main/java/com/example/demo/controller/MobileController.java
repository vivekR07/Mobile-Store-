package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.MobilePhone;
import com.example.demo.exception.MobilePhonesNotFoundException;
import com.example.demo.service.MobileService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	private MobileService service;

	@GetMapping("/mobiles")
	@Operation(summary = "To get all details")
	public ResponseEntity<?> get() {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getAllMobiles(), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/mobiles>10k")
	@Operation(summary = "mobiles phones > 10k")
	public ResponseEntity<?> get11() {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getMobilePhone(0), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	
//	@GetMapping("/uniqueModelName")
//	@Operation(summary = "to find total num of mobiles which having unique model name")
//	public ResponseEntity<?> get111() {
//		ResponseEntity<?> response;
//		try {
//			response = new ResponseEntity<>(service.getMobilePhones(), HttpStatus.OK);
//		} catch (MobilePhonesNotFoundException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//			e.printStackTrace();
//		}
//		return response;
//	}
	
	@GetMapping("/Processor/{name}")
	@Operation(summary = "get details which have same processor")
	public ResponseEntity<?> getByName111(@PathVariable(value = "name") String name)  {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getByProcessor(name), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	@GetMapping("/Color/{name}")
	@Operation(summary = "get details which have same color")
	public ResponseEntity<?> getByName1111(@PathVariable(value = "name") String name)  {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getByColor(name), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			e.printStackTrace();
		}
		return response;
	}
	// DTOS
	@GetMapping("/mobileDto")
	@Operation(summary = "To get all details of Dto")
	public ResponseEntity<?> get1() {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getAllMobilePhones(), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
    
	@GetMapping("/mobileDto/{id}")
	@Operation(summary = "To get DTO details from DB using ID")
	public ResponseEntity<?> getById1(@PathVariable(value = "id") int id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneById(id), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}

	@GetMapping("/{id}")
	@Operation(summary = "To get the details of mobile from DB using ID")
	public ResponseEntity<?> getById(@PathVariable(value = "id") int id) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneById2(id), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}

	@GetMapping("/name/{name}")
	@Operation(summary = "To get the details of mobile from DB using brandName")
	public ResponseEntity<?> getByName(@PathVariable(value = "name") String name) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneByBrandName1(name), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}
	@GetMapping("/DtoBrandname/{name}")
	@Operation(summary = "To get dto mobile from DB using brandName")
	public ResponseEntity<?> getByName11(@PathVariable(value = "name") String name) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneByBrandName(name), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}

	@GetMapping("/modelname/{name}")
	@Operation(summary = "To get the details of mobile from DB using modelName")
	public ResponseEntity<?> getByName1(@PathVariable(value = "name") String name) {
		ResponseEntity<?> response;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneByModelName1(name), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}
    @DeleteMapping("/delete/{id}")
    @Operation(summary="to delete with the specified id")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) throws MobilePhonesNotFoundException {
		ResponseEntity<?> response=null;
		try {
			response = new ResponseEntity<>(service.deleteMobilePhone(id), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}
    @PutMapping("/update/{id}")
    @Operation(summary="to edit with the specified id") 
	public ResponseEntity<?> put(@RequestBody MobilePhone mobile) {
		ResponseEntity<?> response = null;
		
			try {
				response = new ResponseEntity<>(service.editMobilephone(mobile), HttpStatus.OK);
			} catch (MobilePhonesNotFoundException e) {
				// TODO Auto-generated catch block
				response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			}
		return response;
	}
    @PostMapping("/mobilePhone")
	@Operation(summary="To add the mobile details to database")
	public ResponseEntity<?> post(@RequestBody MobilePhone mobile) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.saveMobilePhone(mobile), HttpStatus.OK);
		} catch (MobilePhonesNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		return response;
	}
   
}

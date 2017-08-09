package com.mfus.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfus.training.form.G00RegisterForm;
import com.mfus.training.service.G00RegisterService;
//step 1
//เพื่อประกาศว่า class นี้เป็น controller เพื่อใช้รับส่ง REST API
@RestController
@RequestMapping(value="/g00Register")
@SuppressWarnings("rawtypes")
public class G00RegisterController {
	
	//step 2
	@Autowired
	private G00RegisterService g00RegisterService;
	
	// angular send url => 
	// http://localhost:8080/mfus-training-sp/g00Register/createStudent
	@RequestMapping(value="/createStudent")
	//step 4 change void method to return ResponsEntity
	public ResponseEntity createStudent(@RequestBody G00RegisterForm form) {
		//step 3
		//step 5 add try catch
		try {
			g00RegisterService.createStudent(form);
			//step 6 return status
			return new ResponseEntity("insert success",HttpStatus.OK);
		}catch (Exception e) {
			//step 7 return error message
			return new ResponseEntity("error",HttpStatus.FAILED_DEPENDENCY);
		} 
	}
	
	//step 8 doSearch method
	@RequestMapping(value="/doSearch")
	public ResponseEntity<?> doSearch(@RequestBody G00RegisterForm form){
		// step 9 add try catch
		List<G00RegisterForm> result = new ArrayList<G00RegisterForm>();
		try {
			result = g00RegisterService.doSearch(form);
			return  new ResponseEntity<List<G00RegisterForm>>(result,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//step 10
	@RequestMapping("/getDataByStudentRef/{studentRef}")
	public ResponseEntity getDataByStudentRef(@PathVariable("studentRef") int studentRef) {
		G00RegisterForm form = new G00RegisterForm();
		try {
			form = g00RegisterService.getDataByStudentRef(studentRef);
			return new ResponseEntity<G00RegisterForm>(form, HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@RequestMapping(value="/doUpdate")
	public ResponseEntity doUpdate(@RequestBody G00RegisterForm form) {

		try {
			g00RegisterService.doUpdate(form);
			return new ResponseEntity("update success",HttpStatus.OK);
		}catch (Exception e) {
			//step 7 return error message
			return new ResponseEntity("error",HttpStatus.FAILED_DEPENDENCY);
		} 
	}
	
	
	
	
	
	
	
	
	
	

}

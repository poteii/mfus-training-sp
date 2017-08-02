package com.mfus.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfus.training.entity.RftDistrict;
import com.mfus.training.entity.RftMajor;
import com.mfus.training.entity.RftProvince;
import com.mfus.training.entity.RftSchool;
import com.mfus.training.entity.RftSubDistrict;
import com.mfus.training.entity.RftTitleName;
import com.mfus.training.service.UtilsService;



@RestController
@RequestMapping("/utils")
public class UtilsController {

	@Autowired
	private UtilsService utilsService;

	@RequestMapping(value = "/getProvinces")
	public List<RftProvince> getProvinces() {
		return utilsService.getProvinces();
	}

	@RequestMapping(value = "/getDistricts")
	public List<RftDistrict> getDistricts() {
		return utilsService.getDistricts();
	}

	@RequestMapping(value = "/getSubDistricts")
	public List<RftSubDistrict> getSubDistricts() {
		return utilsService.getSubDistricts();
	}

	@RequestMapping(value = "/getSchools")
	public List<RftSchool> getSchools() {
		return utilsService.getSchools();
	}

	@RequestMapping(value = "/getMajors")
	public List<RftMajor> getMajors() {
		return utilsService.getMajors();
	}
	
	@RequestMapping(value = "/getTitleNames")
	public List<RftTitleName> getTitleNames() {
		return utilsService.getTitleNames();
	}

}

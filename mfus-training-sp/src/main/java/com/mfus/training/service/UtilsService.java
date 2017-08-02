package com.mfus.training.service;

import java.io.Serializable;
import java.util.List;

import com.mfus.training.entity.RftDistrict;
import com.mfus.training.entity.RftMajor;
import com.mfus.training.entity.RftProvince;
import com.mfus.training.entity.RftSchool;
import com.mfus.training.entity.RftSubDistrict;
import com.mfus.training.entity.RftTitleName;



public interface UtilsService extends Serializable {

	public List<RftProvince> getProvinces();

	public List<RftDistrict> getDistricts();

	public List<RftSubDistrict> getSubDistricts();

	public List<RftSchool> getSchools();

	public List<RftMajor> getMajors();

	public List<RftTitleName> getTitleNames();

}

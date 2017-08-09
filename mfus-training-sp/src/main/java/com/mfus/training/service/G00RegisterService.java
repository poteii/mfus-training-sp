package com.mfus.training.service;

import java.io.Serializable;
import java.util.List;

import com.mfus.training.form.G00RegisterForm;

public interface G00RegisterService extends Serializable {
	
	public void createStudent(G00RegisterForm form);

	public List<G00RegisterForm> doSearch(G00RegisterForm form);

	public G00RegisterForm getDataByStudentRef(int studentRef);

}

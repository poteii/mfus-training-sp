package com.mfus.training.service;

import java.io.Serializable;

import com.mfus.training.form.G00RegisterForm;

public interface G00RegisterService extends Serializable {
	
	public void createStudent(G00RegisterForm form);

}

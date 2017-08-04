package com.mfus.training.form;

import java.io.Serializable;

import com.mfus.training.entity.G00Student;
import com.mfus.training.entity.G00User;

public class G00RegisterForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public G00Student g00Student;
	public G00User g00User;
	
	public G00Student getG00Student() {
		return g00Student;
	}
	public void setG00Student(G00Student g00Student) {
		this.g00Student = g00Student;
	}
	public G00User getG00User() {
		return g00User;
	}
	public void setG00User(G00User g00User) {
		this.g00User = g00User;
	}

}

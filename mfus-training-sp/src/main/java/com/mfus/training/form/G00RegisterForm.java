package com.mfus.training.form;

import java.io.Serializable;

import com.mfus.training.entity.G00Student;
import com.mfus.training.entity.G00User;
import com.mfus.training.entity.RftMajor;
import com.mfus.training.entity.RftSchool;

public class G00RegisterForm implements Serializable {

	
	private static final long serialVersionUID = 1L;

	//for insert/search
	private G00Student 		g00Student;
	private G00User 		g00User;
	
	//for search add 08/08/2017
	//ใช้แสดงผลในตาราง
	private RftSchool rftSchool;
	private RftMajor rftMajor;
	//=============================
	//right click source generate getter/setter
	
	
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
	public RftSchool getRftSchool() {
		return rftSchool;
	}
	public void setRftSchool(RftSchool rftSchool) {
		this.rftSchool = rftSchool;
	}
	public RftMajor getRftMajor() {
		return rftMajor;
	}
	public void setRftMajor(RftMajor rftMajor) {
		this.rftMajor = rftMajor;
	}
	
	
	
}

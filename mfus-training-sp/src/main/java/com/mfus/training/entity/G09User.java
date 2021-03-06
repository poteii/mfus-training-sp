package com.mfus.training.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the g09_user database table.
 * 
 */
@Entity
@Table(name="g09_user")
@NamedQuery(name="G09User.findAll", query="SELECT g FROM G09User g")
public class G09User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_ref")
	private int userRef;

	@Column(name="active_flag")
	private String activeFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_datetime")
	private Date createDatetime;

	@Column(name="create_user")
	private int createUser;

	@Column(name="manage_officer_flag")
	private String manageOfficerFlag;

	@Column(name="officer_ref")
	private int officerRef;

	private String password;

	@Column(name="student_ref")
	private int studentRef;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_datetime")
	private Date updateDatetime;

	@Column(name="update_user")
	private int updateUser;

	@Column(name="user_id")
	private String userId;

	@Column(name="user_role")
	private String userRole;

	public G09User() {
	}

	public int getUserRef() {
		return this.userRef;
	}

	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public int getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public String getManageOfficerFlag() {
		return this.manageOfficerFlag;
	}

	public void setManageOfficerFlag(String manageOfficerFlag) {
		this.manageOfficerFlag = manageOfficerFlag;
	}

	public int getOfficerRef() {
		return this.officerRef;
	}

	public void setOfficerRef(int officerRef) {
		this.officerRef = officerRef;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStudentRef() {
		return this.studentRef;
	}

	public void setStudentRef(int studentRef) {
		this.studentRef = studentRef;
	}

	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public int getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
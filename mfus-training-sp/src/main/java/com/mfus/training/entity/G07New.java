package com.mfus.training.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the g07_news database table.
 * 
 */
@Entity
@Table(name="g07_news")
@NamedQuery(name="G07New.findAll", query="SELECT g FROM G07New g")
public class G07New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="news_ref")
	private int newsRef;

	@Column(name="active_flag")
	private String activeFlag;

	@Column(name="create_datetime")
	private Timestamp createDatetime;

	@Column(name="create_user")
	private int createUser;

	@Column(name="news_detail")
	private String newsDetail;

	@Lob
	@Column(name="news_image")
	private byte[] newsImage;

	@Column(name="news_name")
	private String newsName;

	@Column(name="news_topic")
	private String newsTopic;

	@Column(name="news_type")
	private String newsType;

	@Temporal(TemporalType.DATE)
	@Column(name="publish_date")
	private Date publishDate;

	@Column(name="update_datetime")
	private Timestamp updateDatetime;

	@Column(name="update_user")
	private int updateUser;

	public G07New() {
	}

	public int getNewsRef() {
		return this.newsRef;
	}

	public void setNewsRef(int newsRef) {
		this.newsRef = newsRef;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Timestamp getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public int getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public String getNewsDetail() {
		return this.newsDetail;
	}

	public void setNewsDetail(String newsDetail) {
		this.newsDetail = newsDetail;
	}

	public byte[] getNewsImage() {
		return this.newsImage;
	}

	public void setNewsImage(byte[] newsImage) {
		this.newsImage = newsImage;
	}

	public String getNewsName() {
		return this.newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getNewsTopic() {
		return this.newsTopic;
	}

	public void setNewsTopic(String newsTopic) {
		this.newsTopic = newsTopic;
	}

	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Timestamp getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public int getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

}
package com.mfus.training.query;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mfus.training.form.G00RegisterForm;

public class G00StudentQuery implements Serializable {

	//step 1 add serial
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//step 2 create method for find max student_ref
	public static int genMaxStudentRef(EntityManager em) {
		//step 3 create variable
		Query query;
		String selectClause;
		String fromClause;
		try {
			selectClause = "SELECT COALESCE(max(student_ref + 1),1) ";
			fromClause = "FROM g00_student";
			
			query = em.createNativeQuery(selectClause + fromClause);
			
			return new Integer(query.getSingleResult().toString());
			
		}finally {
			
		}
	}

	public static List<Object> doSearch(G00RegisterForm form, EntityManager em) {
		//add try catch
		Query query;
		String selectClause;
		String fromClause;
		String whereClause = "";
		String orderClause;
		boolean isFirst = true;
		try {
			selectClause = "select student.student_ref ";
			fromClause = "from g00_student student ";
			/*check ก่อนว่า personalId ที่ส่งมา มีค่าหรือไม่ ถ้ามีก็ให้ where
			isFirst คือการเช็คว่า นี่ใช่การ where ครั้งแรกหรือไม่ ถ้าใช่ให้ใส่คำว่า where ไป ตามด้วยเงื่อนไข
			ถ้าไม่ใช่ ให้ใส่คำว่า and ไปตามด้วยเงื่อนไข
			ตัวอย่าง เช่น isFirst = true เราจะได้ query => 
			select student.student_ref from g00_student student 
			where student.personal_id like '%xxxxx%'
			เสร็จแล้ว เราก็เปลี่ยนค่าให้ isFirst = false เพื่อรับเงื่อนไขถัดไป */
			if(form.getG00Student().getPersonalId() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.personal_id like '%" 
						+ form.getG00Student().getPersonalId()
						+ "%' ";
				isFirst = false;
			}
			
			/*
			 * isFirst = false เราจะได้ query => 
			 * select student.student_ref from g00_student student 
			 * where student.personal_id like '%xxxxx%'
			 * and student.first_name_t like '%xxxxx%'
			 * */
			if(form.getG00Student().getFirstNameT() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.first_name_t like '%" 
						+ form.getG00Student().getFirstNameT()
						+ "%' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getLastNameT() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.last_name_t like '%" 
						+ form.getG00Student().getLastNameT()
						+ "%' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getFirstNameE() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.first_name_e like '%" 
						+ form.getG00Student().getFirstNameE()
						+ "%' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getLastNameE() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.last_name_e like '%" 
						+ form.getG00Student().getLastNameE()
						+ "%' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getStudentId() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.student_id like '%" 
						+ form.getG00Student().getStudentId()
						+ "%' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getSchoolRef() != 0) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.school_ref = '" 
						+ form.getG00Student().getSchoolRef()
						+ "' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getMajorRef() != 0) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.major_ref = '" 
						+ form.getG00Student().getMajorRef()
						+ "' ";
				isFirst = false;
			}
			
			if(form.getG00Student().getEducationLevel() != null) {
				whereClause += (isFirst ? " WHERE " : " AND ") 
						+ "student.education_level = '" 
						+ form.getG00Student().getEducationLevel()
						+ "' ";
				isFirst = false;
			}
			
			orderClause = " order by student.personal_id asc ";
			
			query = em.createNativeQuery(selectClause + fromClause + whereClause + orderClause);
			
			return query.getResultList();
		}finally {
			
		}
	}

}

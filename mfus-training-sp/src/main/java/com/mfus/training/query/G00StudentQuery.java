package com.mfus.training.query;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

}

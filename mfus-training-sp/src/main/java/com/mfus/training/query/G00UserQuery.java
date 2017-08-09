package com.mfus.training.query;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class G00UserQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int genMaxUserRef(EntityManager em) {
		Query query;
		String selectClause;
		String fromClause;
		try {
			selectClause = "SELECT COALESCE(max(user_ref + 1),1) ";
			fromClause = "FROM g00_user";
			
			query = em.createNativeQuery(selectClause + fromClause);
			
			return new Integer(query.getSingleResult().toString());
			
		}finally {
			
		}
	}

	public static Object getUserByStudentRef(int studentRef, EntityManager em) {
		Query query;
		String selectClause;
		String fromClause;
		String whereClause;
		try {
			selectClause = "SELECT acUser.user_ref ";
			fromClause = "FROM g00_user acUser ";
			whereClause = "WHERE acUser.student_Ref = " + studentRef;

			query = em.createNativeQuery(selectClause + fromClause + whereClause);

			if(query.getResultList().size() > 0) {
				return (Object) query.getResultList().get(0);
			}

		} finally {

		}
		return null;
	}

}

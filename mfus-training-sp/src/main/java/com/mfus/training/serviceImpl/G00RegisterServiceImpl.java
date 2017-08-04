package com.mfus.training.serviceImpl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mfus.training.entity.G00Student;
import com.mfus.training.entity.G00User;
import com.mfus.training.form.G00RegisterForm;
import com.mfus.training.query.G00StudentQuery;
import com.mfus.training.query.G00UserQuery;
import com.mfus.training.service.G00RegisterService;

/*
 * @Service ประกาศว่า class นี้เป็น service class
 * @Repository ประกาศว่า class นี้เป็น Repository class ใช้เพื่อทำการบันทึกข้อมูลลง database
 * @Transactionalใช้เพื่อ control การเปิด ปิด ระหว่าง service กับ database
 * */
//step 1 
@Service
@Repository
@Transactional
public class G00RegisterServiceImpl implements G00RegisterService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//step 2
	@PersistenceContext
	EntityManager em;

	@Override
	public void createStudent(G00RegisterForm form) {
		//step 3 add try finally
		int studentRef;
		try {
			//step 4 create method createG00Student(form)
			studentRef = createG00Student(form);
			//step 8 create method createG00User(form,studentRef)
			createG00User(form,studentRef);
		}finally {
			
		}
	}

	private void createG00User(G00RegisterForm form, int studentRef) {
		// step 9 add try finally
		// step 10 create variable
		G00User g00User;
		int userRef;
		try {
			g00User = new G00User();
			userRef = G00UserQuery.genMaxUserRef(em);
			g00User.setUserRef(userRef);
			g00User.setUserId(form.getG00Student().getPersonalId());
			g00User.setPassword(form.getG00Student().getPersonalId());
			g00User.setUserRole("1");
			g00User.setStudentRef(studentRef);
			g00User.setOfficerRef(0);
			g00User.setManageOfficerFlag(null);
			g00User.setActiveFlag("1");
			g00User.setCreateUser(studentRef);
			g00User.setUpdateUser(studentRef);
			g00User.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
			g00User.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			
			em.persist(g00User);
			
		}finally {
			
		}
		
	}

	private int createG00Student(G00RegisterForm form) {
		// step 5 add try finally
		// step 6 create variable entity (G00Student)
		G00Student g00Student;
		//step 8 find max student_ref from query
		int studentRef;
		try {
			//step 7 declare g00Student
			g00Student = new G00Student();
			studentRef = G00StudentQuery.genMaxStudentRef(em);
			g00Student.setStudentRef(studentRef);
			//entity						(value from front-end)
			g00Student.setEducationLevel(form.getG00Student().getEducationLevel());
			g00Student.setPersonalId(form.getG00Student().getPersonalId());
			g00Student.setStudentId(form.getG00Student().getStudentId());
			g00Student.setGender(form.getG00Student().getGender());
			g00Student.setBirthDate(form.getG00Student().getBirthDate());
			g00Student.setTitleCode(form.getG00Student().getTitleCode());
			g00Student.setFirstNameT(form.getG00Student().getFirstNameT());
			g00Student.setLastNameT(form.getG00Student().getLastNameT());
			g00Student.setFirstNameE(form.getG00Student().getFirstNameE());
			g00Student.setLastNameE(form.getG00Student().getLastNameE());
			g00Student.setSchoolRef(form.getG00Student().getSchoolRef());
			g00Student.setMajorRef(form.getG00Student().getMajorRef());
			g00Student.setNationality(form.getG00Student().getNationality());
			g00Student.setRace(form.getG00Student().getRace());
			g00Student.setReligion(form.getG00Student().getReligion());
			g00Student.setPhoneNo(form.getG00Student().getPhoneNo());
			g00Student.setEmail(form.getG00Student().getEmail());
			//สเปคบอกว่าให้เอา personalId มาบันทึก
			g00Student.setProfileName(form.getG00Student().getPersonalId());
			g00Student.setProfileType(form.getG00Student().getProfileType());
			g00Student.setProfileImage(form.getG00Student().getProfileImage());
			
			g00Student.setCreateUser(studentRef);
			g00Student.setUpdateUser(studentRef);
			g00Student.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
			g00Student.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
			
			//persist = save to database => save g00Student to database
			em.persist(g00Student);
			//return studentRef 
			return studentRef;

			
		}finally {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.mfus.training.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mfus.training.entity.G00Student;
import com.mfus.training.entity.G00User;
import com.mfus.training.entity.RftMajor;
import com.mfus.training.entity.RftSchool;
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

	@Override
	public List<G00RegisterForm> doSearch(G00RegisterForm form) {
		//step s1 add try/catch
		List<G00RegisterForm> resultList = new ArrayList<G00RegisterForm>();//list ที่ใช้ในการ return
		List<Object> objList = new ArrayList<Object>();//list ที่ใช้ในการรับค่าจาก query
		G00RegisterForm registerForm;
		G00Student g00Student;
		RftSchool rftSchool;
		RftMajor rftMajor;
		try {
			objList = G00StudentQuery.doSearch(form,em);
			System.out.println("size = " + objList.size());
			for(Object obj : objList) {
				// begin new object
				registerForm = new G00RegisterForm();
				g00Student = new G00Student();
				rftSchool = new RftSchool();
				rftMajor = new RftMajor();
				registerForm.setG00Student(new G00Student());
				registerForm.setRftMajor(new RftMajor());
				registerForm.setRftSchool(new RftSchool());
				//end new object
				
				//begin find data
				/*em.find(EntityClass,PK)*/
				g00Student = em.find(G00Student.class, obj);
				
				if(g00Student.getSchoolRef() != 0) {
					rftSchool = em.find(RftSchool.class, g00Student.getSchoolRef());
				}
				
				if(g00Student.getMajorRef() != 0) {
					rftMajor = em.find(RftMajor.class, g00Student.getMajorRef());
				}
				//end find data
				
				
				//begin set data to form
				registerForm.setG00Student(g00Student);
				registerForm.setRftSchool(rftSchool);
				registerForm.setRftMajor(rftMajor);
				//end set data to form
				
				//begin add into list
				resultList.add(registerForm);
				//end add into list
			}
			return resultList;
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultList;
	}

	@Override
	public G00RegisterForm getDataByStudentRef(int studentRef) {
		G00RegisterForm form;
		G00Student g00Student;
		try {
			form = new G00RegisterForm();
			g00Student = new G00Student();
			
			g00Student = em.find(G00Student.class, studentRef);
			if(g00Student != null) {
				form.setG00Student(new G00Student());
				form.setG00Student(g00Student);
			}
			
			return form;
		}finally {
			
		}
	}

	
	
	@Override
	public void doUpdate(G00RegisterForm form) {
		try {

			updateG00Student(form);
			updateG00User(form);

		} finally {

		}
	}

	private void updateG00Student(G00RegisterForm form) {
		G00Student g00Student;
		int studentRef;
		try {
			g00Student = new G00Student();
			studentRef = form.getG00Student().getStudentRef();
			g00Student = em.find(G00Student.class, studentRef);
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

			g00Student.setProfileName(form.getG00Student().getProfileName());
			g00Student.setProfileType(form.getG00Student().getProfileType());
			g00Student.setProfileImage(form.getG00Student().getProfileImage());

			g00Student.setUpdateUser(studentRef);
			g00Student.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));

			em.merge(g00Student);
		} finally {

		}
	}

	private void updateG00User(G00RegisterForm form) {
		G00User g00User;
		Object obj;
		try {
			g00User = new G00User();
			obj = G00UserQuery.getUserByStudentRef(form.getG00Student().getStudentRef(),em);
			g00User = em.find(G00User.class, obj);
			g00User.setUserId(form.getG00Student().getPersonalId());
			g00User.setPassword(form.getG00Student().getPersonalId());

			g00User.setUpdateUser(g00User.getUserRef());
			g00User.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));

			em.merge(g00User);
		} finally {

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

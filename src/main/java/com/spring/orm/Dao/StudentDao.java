package com.spring.orm.Dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.Entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		
	 int i = (int) this.hibernateTemplate.save(student);
		return i;
	}
	//get single data object
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	//get all data 
	public List<Student> getAllStudents(){
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	//delete data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
		System.out.println("Data deleted");
	}
	
	//update data
	@Transactional
	public void updateStudent(Student student){
		this.hibernateTemplate.update(student);
		System.out.println("data updated");
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}

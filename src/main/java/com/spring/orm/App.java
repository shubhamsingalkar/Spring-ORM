package com.spring.orm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.Entities.Student;


public class App 
{
	public static void main( String[] args )
	{

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao stu = context.getBean("dao",StudentDao.class);

		Scanner sc=new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		while(go) {

			System.out.println("1. Add");
			System.out.println("2.Select all");
			System.out.println("3. get one");
			System.out.println("4. Delete");
			System.out.println("5. Update");
			System.out.println("6. Exit");

			try {
				//int input = Integer.parseInt(br.readLine());
				int input=Integer.parseInt(sc.next());
				switch (input) {
				case 1:
					System.out.println("Enter ID: "); int studentId=sc.nextInt();
					System.out.println("Enter Name: "); String studentName=sc.next();
					System.out.println("Enter City; "); String studentCity=sc.next();
					stu.insert(new Student(studentId, studentName, studentCity));
					System.out.println("===Data Added Successfully===");
					break;

				case 2:
					List<Student> allStudents = stu.getAllStudents();
					for(Student ss:allStudents) {
						System.out.println("ID: "+ss.getStudentId());
						System.out.println("Name: "+ss.getStudentName());
						System.out.println("City: "+ss.getStudentCity());
						System.out.println("________________________");
					}
					break;

				case 3:
					System.out.println("Enter ID to get Student");
					int studentId1=sc.nextInt();
					Student student = stu.getStudent(studentId1);
					System.out.println("ID: "+student.getStudentId());
					System.out.println("Name: "+student.getStudentName());
					System.out.println("City: "+student.getStudentCity());
					System.out.println("________________________");
					break;
				case 4:
					System.out.println("Enter ID to Delete Student");
					int stuID=sc.nextInt();
					stu.deleteStudent(stuID);System.out.println("===Student deleted Successfully===");
					break;
				case 5:
					System.out.println("Enter ID to UPDATE: ");int studentId2=sc.nextInt();
					System.out.println("Enter Name to UPDATE: "); String studentName2=sc.next();
					System.out.println("Enter City to UPDATE: "); String studentCity2=sc.next();
					stu.updateStudent(new Student(studentId2, studentName2, studentCity2));
					break;
				case 6:
					go=false;
					
				default:
					System.out.println("===Please enter number from 1-6 only===");
				}
			}
			catch (Exception e) {
				System.out.println("===Please enter valid input===");
				//e.printStackTrace();
			}
		}
		System.out.println("Thank you for using our application");
		System.out.println("See you soon....!!!");
	}
}

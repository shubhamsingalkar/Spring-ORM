package com.spring.orm;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.Entities.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao stu = context.getBean("dao",StudentDao.class);
        
        //int i = stu.insert(new Student(101,"Virat","Pune"));
        int j=stu.insert(new Student(111, "Kapil","Nagpur"));
        
        
        System.out.println("done"+j);
    }
}

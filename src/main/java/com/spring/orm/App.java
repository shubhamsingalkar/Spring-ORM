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
        Student student=new Student(101,"Virat","Pune");
        int i = stu.insert(student);
        System.out.println("done"+i);
    }
}

package com.volkanturhan.cruddemo;

import com.volkanturhan.cruddemo.dao.StudentDAO;
import com.volkanturhan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
		// createStudent(studentDAO);
		//	createMultipleStudent(studentDAO);
		readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}
	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 students object ...");
		Student tempStudent1 = new Student("Volkan","Turhan","info@volkanturhan.com");
		Student tempStudent2 = new Student("Yücel","Yildirim","info@yucelyildirim.com");
		Student tempStudent3 = new Student("Ilker","Turker","info@ilkerturker.com");
		//save the students object
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Volkan","Turhan","info@volkanturhan.com");
		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}

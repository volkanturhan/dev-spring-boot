package com.volkanturhan.cruddemo;

import com.volkanturhan.cruddemo.dao.StudentDAO;
import com.volkanturhan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.PrintStream;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private PrintStream out;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : "+ numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Deleting student with id : "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
			int studentId=1;
			System.out.println("Getting student with id : "+ studentId);
			Student myStudent = studentDAO.findById(studentId);
		// change first name to "Scoopy"
		System.out.println("Updating student");
		myStudent.setFirstName("John");
		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println("Updated student : " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Turhan");
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}
	private void readStudent(StudentDAO studentDAO) {

		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("İlker", "Türker", "daffy@luv2code.com");

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

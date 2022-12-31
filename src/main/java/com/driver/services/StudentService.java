package com.driver.services;

import com.driver.models.Card;
import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;


    public Student getDetailsByEmail(String email){
        Student student = studentRepository4.findByEmailId(email);

        return student;
    }

    public Student getDetailsById(int id){

        Optional<Student> student1 = Optional.ofNullable(studentRepository4.findById(id));
        return student1.get();
    }

    public void createStudent(Student student){
        Card card1 = cardService4.createAndReturn(student);
        student.setCard(card1);
        studentRepository4.save(student);

    }

    public void updateStudent(Student student){
        studentRepository4.updateStudentDetails(student);

    }

    public void deleteStudent(int id){
        cardService4.deactivateCard(id);
        //Delete student and deactivate corresponding card

       studentRepository4.deleteCustom(id);
    }
}

package br.edu.impacta.campuslib.service;

import br.edu.impacta.campuslib.model.Student;
import br.edu.impacta.campuslib.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return  studentRepository.findAll();
    }

    public Student updateStudent(Student oldStudent, Student newStudent){
        oldStudent.setName(newStudent.getName());
        oldStudent.setStudentGroup(newStudent.getStudentGroup());
        oldStudent.setIdCard(newStudent.getIdCard());

        return studentRepository.save(newStudent);
    }

    public Student findStudentById(UUID id){
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student by ID " + id + " was not found"));
    }

    @Transactional
    public void deleteStudent(UUID id){
        studentRepository.deleteStudentById(id);
    }
}

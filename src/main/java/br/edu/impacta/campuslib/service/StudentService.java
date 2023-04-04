package br.edu.impacta.campuslib.service;

import br.edu.impacta.campuslib.exception.UserNotFoundException;
import br.edu.impacta.campuslib.model.Student;
import br.edu.impacta.campuslib.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addEstudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return  studentRepository.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id){
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("Studend by ID " + " was not found"));
    }

    public void deleteStudent(Long id){
        studentRepository.deleteStudentById(id);
    }
}

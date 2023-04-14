package br.edu.impacta.campuslib.controller;

import br.edu.impacta.campuslib.model.Student;
import br.edu.impacta.campuslib.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ModelAndView getAllStudents(){
        ModelAndView mav = new ModelAndView("list-students");
        List<Student> students = studentService.findAllStudents();
        mav.addObject("students", students);
        return mav;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") UUID id){
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/add")
    public ModelAndView addStudentForm(){
        ModelAndView mav = new ModelAndView("add-student-form");
        Student student = new Student();
        mav.addObject("student", student);
        return mav;
    }

    @PostMapping("/save")
    public RedirectView saveStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return new RedirectView("/student/all");
    }
}

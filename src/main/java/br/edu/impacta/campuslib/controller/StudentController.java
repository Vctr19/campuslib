package br.edu.impacta.campuslib.controller;

import br.edu.impacta.campuslib.model.Student;
import br.edu.impacta.campuslib.service.StudentService;
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

    @GetMapping("/add")
    public ModelAndView addStudentForm(){
        ModelAndView mav = new ModelAndView("add-student-form");
        mav.addObject("student", new Student());
        return mav;
    }

    @PostMapping("/save")
    public RedirectView saveStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return new RedirectView("/student/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editStudentForm(@PathVariable UUID id){
        ModelAndView mav = new ModelAndView("edit-student-form");
        mav.addObject("student", studentService.findStudentById(id));
        return mav;
    }

    @PostMapping("/update/{id}")
    public RedirectView updateStudent(@PathVariable UUID id, @ModelAttribute("student") Student student){
        Student oldStudent = studentService.findStudentById(id);
        studentService.updateStudent(oldStudent, student);
        return new RedirectView("/student/all");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteStudent(@PathVariable UUID id){
        studentService.deleteStudent(id);
        return new RedirectView("/student/all");
    }
}

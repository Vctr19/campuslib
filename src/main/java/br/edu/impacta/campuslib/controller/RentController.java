package br.edu.impacta.campuslib.controller;

import br.edu.impacta.campuslib.model.Book;
import br.edu.impacta.campuslib.model.Rent;
import br.edu.impacta.campuslib.model.Student;
import br.edu.impacta.campuslib.service.BookService;
import br.edu.impacta.campuslib.service.RentService;
import br.edu.impacta.campuslib.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rent")
public class RentController {

    public final RentService rentService;
    private final StudentService studentService;
    private final BookService bookService;

    public RentController(RentService rentService, StudentService studentService, BookService bookService) {
        this.rentService = rentService;
        this.studentService = studentService;
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ModelAndView getAllRents(){
        ModelAndView mav = new ModelAndView("list-rents");
        mav.addObject("rents", rentService.findAllRents());
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addRentForm(){
        ModelAndView mav = new ModelAndView("add-rent-form");
        mav.addObject("rent", new Rent());
        mav.addObject("students", studentService.findAllStudents());
        mav.addObject("books", bookService.findAllBooks());
        return mav;
    }

    @PostMapping("/save")
    public RedirectView saveRent(@ModelAttribute Rent rent){
        rentService.addRent(rent);
        return new RedirectView("/rent/all");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteRent(@PathVariable UUID id){
        rentService.deleteRent(id);
        return new RedirectView("/rent/all");
    }

    @GetMapping("/by-student/{id}")
    public ModelAndView findAllRentsByStudent(@PathVariable UUID id){
        ModelAndView mav = new ModelAndView("list-rents-by-student");
        mav.addObject("rents", rentService.findAllRentsByStudent(id));
        return mav;
    }

    @GetMapping("/by-book/{id}")
    public ModelAndView findAllRentsByBook(@PathVariable UUID id){
        ModelAndView mav = new ModelAndView("list-rents-by-book");
        mav.addObject("rents", rentService.findAllRentsByBook(id));
        return mav;
    }
}

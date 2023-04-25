package br.edu.impacta.campuslib.controller;

import br.edu.impacta.campuslib.model.Book;
import br.edu.impacta.campuslib.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ModelAndView getAllBooks(){
        ModelAndView mav = new ModelAndView("list-books");
        List<Book> books = bookService.findAllBooks();
        mav.addObject("books", books);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView addBookForm(){
        ModelAndView mav = new ModelAndView("add-book-form");
        Book book = new Book();
        mav.addObject("book", book);
        return mav;
    }

    @PostMapping("/save")
    public RedirectView saveBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return new RedirectView("/book/all");
    }
}

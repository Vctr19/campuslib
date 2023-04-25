package br.edu.impacta.campuslib.service;

import br.edu.impacta.campuslib.exception.BookNotFoundException;
import br.edu.impacta.campuslib.model.Book;
import br.edu.impacta.campuslib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book updateStudent(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(UUID id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book by ID " + " was not found"));
    }

    public void deleteBook(UUID id){
        bookRepository.deleteBookById(id);
    }
}

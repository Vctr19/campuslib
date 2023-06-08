package br.edu.impacta.campuslib.service;

import br.edu.impacta.campuslib.model.Book;
import br.edu.impacta.campuslib.model.Rent;
import br.edu.impacta.campuslib.repository.BookRepository;
import br.edu.impacta.campuslib.repository.RentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RentService {
    private final RentRepository rentRepository;
    private final BookRepository bookRepository;

    @Autowired
    public RentService(RentRepository rentRepository, BookRepository bookRepository) {
        this.rentRepository = rentRepository;
        this.bookRepository = bookRepository;
    }

    public Rent addRent (Rent rent){
        Book rentedBook = rent.getBook();
        rentedBook.setQuantity(rentedBook.getQuantity() - 1);
        return rentRepository.save(rent);
    }

    public List<Rent> findAllRents(){
        return rentRepository.findAll();
    }

    public Rent findRentById(UUID id){
        return rentRepository.findRentById(id)
                .orElseThrow(() -> new RuntimeException("Studend by ID " + " was not found"));
    }

    @Transactional
    public void deleteRent(UUID id){
        Rent rent = findRentById(id);
        Book rentedBook = rent.getBook();
        rentedBook.setQuantity(rentedBook.getQuantity() + 1);
        rentRepository.deleteRentById(id);
    }
}

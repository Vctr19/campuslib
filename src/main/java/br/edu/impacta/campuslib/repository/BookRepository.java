package br.edu.impacta.campuslib.repository;

import br.edu.impacta.campuslib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    void deleteBookById(UUID id);

    Optional<Book> findBookById(UUID id);
}

package br.edu.impacta.campuslib.repository;

import br.edu.impacta.campuslib.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RentRepository extends JpaRepository<Rent, UUID> {
    void deleteRentById(UUID id);

    Optional<Rent> findRentById(UUID id);

    void deleteStudentById(UUID id);
}

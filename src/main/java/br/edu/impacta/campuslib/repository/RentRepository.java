package br.edu.impacta.campuslib.repository;

import br.edu.impacta.campuslib.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RentRepository extends JpaRepository<Rent, UUID> {
    void deleteRentById(UUID id);

    Optional<Rent> findRentById(UUID id);


    @Query(value = "SELECT * FROM tbl_rent WHERE fk_student = :idStudent", nativeQuery = true)
    List<Rent> findAllRentsByStudent(@Param("idStudent") UUID idStudent);

    @Query(value = "SELECT * FROM tbl_rent WHERE fk_book = :idBook", nativeQuery = true)
    List<Rent> findAllRentsByBook(@Param("idBook") UUID idBook);
}

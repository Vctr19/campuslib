package br.edu.impacta.campuslib.repository;

import br.edu.impacta.campuslib.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    void deleteStudentById(UUID id);

    Optional<Student> findStudentById(UUID id);
}

package br.edu.impacta.campuslib.repository;

import br.edu.impacta.campuslib.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}

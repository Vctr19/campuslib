package br.edu.impacta.campuslib.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="tbl_rent")
public class Rent {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name="fk_student")
    private Student student;

    @OneToOne
    @JoinColumn(name="fk_book")
    private Book book;

    public Rent() {
    }

    public Rent(Student student, Book book, int quantity) {
        this.student = student;
        this.book = book;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", fkIdStudent=" + student +
                ", fkIdBook=" + book +
                '}';
    }
}

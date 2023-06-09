package br.edu.impacta.campuslib.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tbl_student")
public class Student {

    enum StudentGroup {
        ADS, RED, SEC,
    }
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "studentGroup")
    @Enumerated(EnumType.STRING)
    private StudentGroup studentGroup;

    @Column(name = "idCard", nullable = false)
    private int idCard;

    public Student() {
    }

    public Student(String name, StudentGroup studentGroup, int idCard) {
        this.name = name;
        this.studentGroup = studentGroup;
        this.idCard = idCard;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public StudentGroup[] getStudentGroupList(){
        return StudentGroup.values();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", studentID=" + idCard +
                '}';
    }
}

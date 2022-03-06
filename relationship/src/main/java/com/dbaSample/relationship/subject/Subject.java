package com.dbaSample.relationship.subject;

import com.dbaSample.relationship.student.Student;
import com.dbaSample.relationship.teacher.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import javax.persistence.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private  String name;

//    @ManyToMany(fetch=FetchType.LAZY)
    @ManyToMany
     @JoinTable(
            name = "students_subjects",
             joinColumns= @JoinColumn(name="subject_id"),
            inverseJoinColumns= @JoinColumn(name="student_id")
    )
    Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacher;
}

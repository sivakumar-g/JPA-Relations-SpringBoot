package com.dbaSample.relationship.student;

import com.dbaSample.relationship.games.Game;
import com.dbaSample.relationship.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;

    //not needed
//    @JsonIgnore
//    @ManyToMany(mappedBy="enrolledStudents",fetch=FetchType.LAZY)
//    Set<Subject> subjects = new HashSet<>();


    //if we did onetomany then mapped by is needed since we can set id to single variable only
//      @OneToMany(mappedBy="studentGame")
//      private Game gameOfStudent;
}

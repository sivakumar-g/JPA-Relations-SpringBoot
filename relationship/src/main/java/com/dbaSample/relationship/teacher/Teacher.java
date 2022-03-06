package com.dbaSample.relationship.teacher;

import com.dbaSample.relationship.games.Game;
import com.dbaSample.relationship.subject.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
/* one needs to comment out like mayToOne or OneToMany

 */
//    @OneToMany(mappedBy="teacher",fetch=FetchType.LAZY)
//    Set<Subject> subjects;

}

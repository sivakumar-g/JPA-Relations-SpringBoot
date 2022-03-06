package com.dbaSample.relationship.games;

import com.dbaSample.relationship.student.Student;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;

    //if we did oneToMany then ManyToOne with mappedBy is needed
    @OneToMany
    @JoinColumn(name = "student_game_id", referencedColumnName = "id")
    public List<Student> studentGame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentGame() {
        return studentGame;
    }

    public void setStudentGame(List<Student> studentGame) {
        this.studentGame = studentGame;
    }
}

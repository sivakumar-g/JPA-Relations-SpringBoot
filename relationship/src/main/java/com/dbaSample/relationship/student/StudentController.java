package com.dbaSample.relationship.student;

import com.dbaSample.relationship.games.Game;
import com.dbaSample.relationship.games.GameRepository;
import com.dbaSample.relationship.subject.Subject;
import com.dbaSample.relationship.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/student"})
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    GameRepository gameRepository;

    @GetMapping
    public List<Student> getStudents(){
      System.out.println("getSTudents");
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }



    @PutMapping("/{studentId}/Game/{gameId}")
    Game addGameToStudent(
            @PathVariable int studentId,
            @PathVariable int gameId
    ){
        Student student = studentRepository.findById(studentId).get();
        Game game = gameRepository.findById(gameId).get();

        game.studentGame.add(student);
        return gameRepository.save(game);
    }


}

package com.dbaSample.relationship.games;

import com.dbaSample.relationship.student.Student;
import com.dbaSample.relationship.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/game"})
public class GameController {


    @Autowired
    GameRepository gameRepository;

    @GetMapping
    public List<Game> getGames(){
        System.out.println("getGames");
        return gameRepository.findAll();
    }

    @PostMapping
    public Game createGame(@RequestBody Game game){
        return gameRepository.save(game);
    }



}

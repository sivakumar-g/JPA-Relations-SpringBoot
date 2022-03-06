package com.dbaSample.relationship.games;

import com.dbaSample.relationship.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Game,Integer> {
}

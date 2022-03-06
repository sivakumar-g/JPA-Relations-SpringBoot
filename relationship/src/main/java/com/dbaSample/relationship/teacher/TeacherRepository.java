package com.dbaSample.relationship.teacher;

import com.dbaSample.relationship.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher,Integer> {
}

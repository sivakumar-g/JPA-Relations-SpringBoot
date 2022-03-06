package com.dbaSample.relationship.subject;

import com.dbaSample.relationship.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<Subject,Integer> {
}

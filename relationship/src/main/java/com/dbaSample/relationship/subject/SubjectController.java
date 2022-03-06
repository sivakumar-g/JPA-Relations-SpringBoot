package com.dbaSample.relationship.subject;

import com.dbaSample.relationship.student.Student;
import com.dbaSample.relationship.student.StudentRepository;
import com.dbaSample.relationship.teacher.Teacher;
import com.dbaSample.relationship.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/subject"})
public class SubjectController {


    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    Subject getSubjectsById(@PathVariable int id) {

        Subject s = subjectRepository.findById(id).get();
        System.out.println(s);
        return s;
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable int subjectId,
            @PathVariable int studentId
    ){
        try {
            Student student = studentRepository.findById(studentId).get();
            Subject subject = subjectRepository.findById(subjectId).get();

            subject.enrolledStudents.add(student);
            return subjectRepository.save(subject);
        }
        catch (Exception e){
            System.out.println("exception");
            Subject resSubject = subjectRepository.findById(subjectId).get();
            return resSubject;
        }
    }//addStudentToSubject

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject addSubjectToTeacher(
            @PathVariable int subjectId,
            @PathVariable int teacherId
    ){
        Teacher teacher = teacherRepository.findById(teacherId).get();
        Subject subject = subjectRepository.findById(subjectId).get();

        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }


}

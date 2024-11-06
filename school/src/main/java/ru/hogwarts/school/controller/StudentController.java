package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.StudentServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
    @RequestMapping("/student")
    public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @GetMapping("{id}/get")
        public ResponseEntity<Student> getStudent(@PathVariable Long id) {
            Student student = studentService.getStudent(id);
            if (student == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(student);
        }

        @PostMapping("create")
        public Student createStudent(@RequestBody Student student) {
            return studentService.creatStudent (student);
        }

        @PutMapping("/id/update")
        public ResponseEntity<Student> updateStudent(@RequestBody Student student,@RequestBody Long id) {
            Student foundStudent = studentService.updateidStudent (student, id);
            if (foundStudent == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.ok(foundStudent);
        }

        @DeleteMapping("{id}/update")
        public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    @GetMapping("/{id}/delete")
    public ResponseEntity<Void> deleteStudents(@PathVariable Long id) {
            studentService.deleteStudent(id);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filterByAge")
public List<Student> getStudentByAge(@RequestParam("age") int age) {
    return studentServise.getStudentByAge(age);

    }






package ru.hogwarts.school;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.StudentServiceImpl;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StudentServiceImplTest {


        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

        @Test
        @DisplayName("Создание студента")
        void createStudent() {
            Student expected = new Student("Max", 20);

            Student actual = studentServiceImpl.creatStudent(expected);

            assertEquals(actual, expected);
        }


        @Test
        @DisplayName("Удаление студента")
        void deleteStudent() {
            Student expected = new Student("Serg", 35);
            Student savedStudent = studentServiceImpl.creatStudent(expected);

            Student actual = studentServiceImpl.deleteStudent(savedStudent.getId());

            assertEquals(actual, savedStudent);
            Student student = studentServiceImpl.updateidStudent(savedStudent);
            assertNull(student);
        }

        @Test
        @DisplayName("Обновление студента")
        void updateStudent() {
            Student expected = new Student("Serg", 35);
            Student savedStudent = studentServiceImpl.creatStudent(expected);

            Student actual = studentServiceImpl.updateidStudent(savedStudent);
            assertEquals(actual, savedStudent);
        }

        @Test
        @DisplayName("Сортировка студентов по возрасту")
        void getStudentByAge() {
            int age = 20;
            Student student = new Student("Tot", 29);
            Student expected1 = new Student("test", age);
            Student expected2 = new Student("test", age);
            studentServiceImpl.creatStudent(student);
            studentServiceImpl.creatStudent(expected1);
            studentServiceImpl.creatStudent(expected2);

            Collection<Student> actual = studentServiceImpl.findByAge(age);

            assertThat(actual).containsAll(List.of(expected1, expected2));

        }
    }


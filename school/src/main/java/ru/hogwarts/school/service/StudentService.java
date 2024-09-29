package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import javax.swing.plaf.PanelUI;
import java.util.Collection;

public interface StudentService {
    Student creatStudent (Student student);
    Student readStudent(long id);
    Student updateidStudent( Student student);
    Student deleteStudent(long id);
    Collection<Student> findByAge(int age);


}

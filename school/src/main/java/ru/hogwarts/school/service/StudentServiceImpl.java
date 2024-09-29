package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static long studentCounter = 1;
    private final Map<Long, Student> studentRepositorry;

    public StudentServiceImpl() {
        this.studentRepositorry = new HashMap<>();
    }

    @Override
    public Student creatStudent (Student student){
        student.setId(studentCounter++);
        studentRepositorry.put(student.getId(), student);
        return student;
    }

    @Override
    public Student  readStudent(long id) {
        return studentRepositorry.get(id);

    }
    @Override
    public Student updateidStudent (Student student) {
        if (!studentRepositorry.containsKey(student.getId())) {
            return null;
        }
        studentRepositorry.put(student.getId(), student);
        return student;
    }
    @Override
    public Student deleteStudent(long id) {
        return studentRepositorry.remove(id);
    }
    @Override
    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student :  studentRepositorry .values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;

}
}


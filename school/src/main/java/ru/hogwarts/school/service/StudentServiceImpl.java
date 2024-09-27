package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static long studentCounter =1;
    private final Map<Long, Student> studentRepositorry;

    public StudentServiceImpl() {
        this.studentRepositorry = new HashMap<>();
    }
}

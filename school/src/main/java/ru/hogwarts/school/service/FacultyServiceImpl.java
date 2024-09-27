package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

public class FacultyServiceImpl implements FacultyService {
    private static long  facultyCounter;
    private final Map<Long, Faculty> studentRepositorry;

    public FacultyServiceImpl() {
        this.studentRepositorry = new HashMap<>();
    }
}

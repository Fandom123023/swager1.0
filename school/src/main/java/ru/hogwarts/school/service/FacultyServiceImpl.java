package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
    public class FacultyServiceImpl implements FacultyService{

        private final HashMap <Long, Faculty> faculties = new HashMap<>();
        private long count = 0;
        @Override
        public Faculty  creatFaculty(Faculty faculty) {
            faculty.setId(count++);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        @Override
        public Faculty readFaculty (long id) {
            return faculties.get(id);
        }
        @Override
        public Faculty  updateidFaculty(Faculty faculty) {
            if (!faculties.containsKey(faculty.getId())) {
                return null;
            }
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        @Override
        public Faculty deleteFaculty(long id) {
            return faculties.remove(id);
        }
        public Collection<Faculty> findByColor(String color) {
            ArrayList<Faculty> result = new ArrayList<>();
            for (Faculty faculty : faculties.values()) {
                if (Objects.equals(faculty.getColor(), color)) {
                    result.add(faculty);
                }
            }
            return result;
        }
    }



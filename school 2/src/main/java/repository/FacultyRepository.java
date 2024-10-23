package repository;

import model.Faculty;

import java.util.List;

public interface FacultyRepository {
    List<Faculty> findAllByColor(String color);
}

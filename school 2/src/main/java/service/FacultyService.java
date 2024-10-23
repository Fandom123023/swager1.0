package service;

import model.Faculty;
import org.springframework.stereotype.Service;
import repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository){
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty, faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }
    public List<Faculty> findFacultyByColor(String color){
        return facultyRepository.findAllByColor(color);
    }

}

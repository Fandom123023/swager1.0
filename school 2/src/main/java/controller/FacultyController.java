package controller;

import model.Faculty;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FacultyService;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }
    @GetMapping("/color/{color}")
    public List<Faculty> findFacultiesColor(@PathVariable String color){
        return facultyService.findFacultyByColor(color);
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id){
        Faculty faculty = facultyService.findFaculty(id);
        if(faculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }
    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty){
        Faculty foundFaculty = FacultyService.updateFaculty(faculty);
        if (foundFaculty == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Collections<Faculty>>
            (@RequestParam(required = false) String color){
        if(color != null && !color.isBlank()){
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }


}

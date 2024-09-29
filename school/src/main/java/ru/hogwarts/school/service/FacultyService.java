package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;


public interface FacultyService {
    Faculty creatFaculty ( Faculty faculty);
    Faculty readFaculty(long id);
    Faculty updateidFaculty (Faculty faculty);
    Faculty deleteFaculty(long id);

}

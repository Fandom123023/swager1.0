package ru.hogwarts.school;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyServiceImpl;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

 class FacultyServiceImplTest {

        FacultyServiceImpl facultyService = new FacultyServiceImpl();


        @Test
        @DisplayName("Создание факультета")
        void createFaculty() {
            Faculty expected = new Faculty("Max", "синий");

            Faculty actual = facultyService.creatFaculty(expected);

            assertEquals(actual, expected);
        }

        @Test
        @DisplayName("Обновление факультета")
        void updateFaculty() {
            Faculty expected = new Faculty("Serg", "Зеленый");
            Faculty savedFaculty = facultyService.creatFaculty(expected);

            Faculty actual = facultyService.updateidFaculty(savedFaculty);
            assertEquals(actual, savedFaculty);
        }


        @Test
        @DisplayName("Удаление факультета")
        void deleteFaculty() {
            Faculty expected = new Faculty("Serg", "Красный");
            Faculty savedFaculty = facultyService.creatFaculty(expected);

            Faculty actual = facultyService.deleteFaculty(savedFaculty.getId());

            assertEquals(actual, savedFaculty);
            Faculty faculty = facultyService.updateidFaculty(savedFaculty);
            assertNull(faculty);
        }

        @Test
        @DisplayName("Сортировка по цвету")
        void getFacultiesByColor() {
            String color = "Blue";
            Faculty faculty = new Faculty("Tot", "Red");
            Faculty expected1 = new Faculty("test", color);
            Faculty expected2 = new Faculty("test", color);
            facultyService.creatFaculty(faculty);
            facultyService.creatFaculty(expected1);
            facultyService.creatFaculty(expected2);

            Collection<Faculty> actual = facultyService.findByColor(color);

            assertThat(actual).containsAll(List.of(expected1, expected2));

        }
    }


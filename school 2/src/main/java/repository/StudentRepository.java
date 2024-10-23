package repository;

import model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Long<Student> findAllByAge(int age);
}

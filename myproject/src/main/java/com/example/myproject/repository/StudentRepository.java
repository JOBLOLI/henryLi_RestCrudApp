package com.example.myproject.repository;

import com.example.myproject.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    List<Student> findAll();

    Student findByName(String name);

    Student findById(long id);
}

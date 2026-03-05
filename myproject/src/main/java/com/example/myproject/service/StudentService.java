package com.example.myproject.service;

import com.example.myproject.entity.Student;
import com.example.myproject.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        s.setId(null); // ensures INSERT not update
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updated.getName());
        existing.setFees(updated.getFees());
        existing.setSubName(updated.getSubName());

        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

}

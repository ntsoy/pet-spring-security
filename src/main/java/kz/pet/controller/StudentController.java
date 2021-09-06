package kz.pet.controller;

import kz.pet.model.Student;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final List<Student> students = List.of(
            new Student(1, "Nikolay Tsoy"),
            new Student(2, "Zhanna Atay"));

    @GetMapping("/api/students/{id}")
    public Student getById(@PathVariable Integer id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Cannot find student by id " + id));
    }
}

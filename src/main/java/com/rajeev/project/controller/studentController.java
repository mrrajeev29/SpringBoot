package com.rajeev.project.controller;

import com.rajeev.project.dto.AddStudentRequestDto;
import com.rajeev.project.dto.studentDto;
import com.rajeev.project.service.studentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor

public class studentController {


    //After creating reopsitory
    private final studentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<studentDto>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body( studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<studentDto> getStudentById(@PathVariable Long id) // Whatever in route as params should be include here to use in function
    {
        return ResponseEntity.ok(studentService.getAllStudentsById(id)); //Line 28 and 34 have same work
    }

    @PostMapping("/addStudent")
    public ResponseEntity<studentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("fullyUpdate/{id}")
    public ResponseEntity<studentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto ) {
        return ResponseEntity.ok( studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("partialUpdate/{id}")
    public ResponseEntity<studentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> update) {
        return ResponseEntity.ok( studentService.updatePartialStudent(id, update));
    }
}

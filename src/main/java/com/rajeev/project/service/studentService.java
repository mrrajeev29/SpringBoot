package com.rajeev.project.service;

import com.rajeev.project.dto.AddStudentRequestDto;
import com.rajeev.project.dto.studentDto;

import java.util.List;
import java.util.Map;

public interface studentService {

    List<studentDto> getAllStudents();

    studentDto getAllStudentsById(Long id);

    studentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    studentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    studentDto updatePartialStudent(Long id, Map<String, Object> update);
}

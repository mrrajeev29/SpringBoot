package com.rajeev.project.service.impl;

import com.rajeev.project.dto.AddStudentRequestDto;
import com.rajeev.project.dto.studentDto;
import com.rajeev.project.entity.Student;
import com.rajeev.project.repository.StudentRepository;
import com.rajeev.project.service.studentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class studentServiceImpl implements studentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<studentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> new studentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }

    @Override
    public studentDto getAllStudentsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not find with this id "+id));
        return modelMapper.map(student, studentDto.class);
    }

    @Override
    public studentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, studentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exists by id "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public studentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto){
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not find with this id "+id));
        modelMapper.map(addStudentRequestDto, student); //it'll map new value
        student = studentRepository.save(student);
        return modelMapper.map(student, studentDto.class);
    }

    @Override
    public studentDto updatePartialStudent(Long id, Map<String, Object> update) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not find with this id "+id));

        update.forEach((field, value)->{
            switch (field) {
                case "name" :
                    student.setName((String) value);
                    break;
                case "email" :
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, studentDto.class);
    }

}
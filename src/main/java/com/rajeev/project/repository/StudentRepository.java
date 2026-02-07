package com.rajeev.project.repository;

import com.rajeev.project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { //Student is the name of entity, Long is type of Id

}

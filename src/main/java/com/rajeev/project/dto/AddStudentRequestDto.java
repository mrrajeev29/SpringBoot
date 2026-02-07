// We have created this class different from studentDto because only name and email is required to create because id we'll be generating, otherwise we can continue with studentDto also


package com.rajeev.project.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data  //All getter setter and constructor will work automatically
public class AddStudentRequestDto {

    @NotBlank(message = "Name is required") //To make it mandatory
    @Size(min = 3, max = 30, message = "Name should be of length 3 to 30") //length should me between 3 to 30
    private String name;

    @NotBlank(message = "Email can't be empty")
    @Email //Should be email
    private  String email;
}

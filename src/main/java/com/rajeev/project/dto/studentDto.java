package com.rajeev.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //All getter setter and constructor will work automatically
@AllArgsConstructor //it will create all arguments constructor
@NoArgsConstructor
public class studentDto {
    private long id;
    private String name;
    private  String email;
}

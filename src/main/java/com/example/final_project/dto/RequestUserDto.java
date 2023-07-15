package com.example.final_project.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class RequestUserDto {
    @Length(min=1, max=20)
    private String login;

    @Length(min=1, max=20)
    private String firstName;

    @Length(min=1, max=20)
    private String lastName;


    @Length(min=5, max=30, message = "Adres email musi zawierać znaki specjalne takie jak @ oraz . " )
    private String email;

}

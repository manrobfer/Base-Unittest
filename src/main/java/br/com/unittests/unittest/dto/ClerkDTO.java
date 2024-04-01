package br.com.unittests.unittest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClerkDTO {

    private int code;
    private String name;

    private int age;

    private Date birthDate;

    private double wages;

}

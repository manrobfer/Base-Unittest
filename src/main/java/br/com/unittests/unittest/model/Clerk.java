package br.com.unittests.unittest.model;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clerk {

    private int code;
    private String name;
    private int age;
    private Date birthDate;
    private double wages;
}

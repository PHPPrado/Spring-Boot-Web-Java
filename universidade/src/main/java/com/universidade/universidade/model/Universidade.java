package com.universidade.universidade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50)
    private String nome;

    @Size(min = 14, max = 14)
    private String cnpj;

    @Size(max = 50)
    private String area;

    private int cep;

    private String site;
}

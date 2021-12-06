package com.kamaathedj.Graphql.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;



public record Customer(@Id Integer id, String name, LocalDate registered) {
}


package com.guidev.futeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "leagues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class League {

    @Id
    private Long id;

    private String name;
    private String type;
    private String logo;

    
}

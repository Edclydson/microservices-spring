package com.example.hrworker.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_worker")
public class Worker{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    private String name;
    private Double dailyIncome;
}

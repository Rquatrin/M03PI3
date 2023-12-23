package com.clinica.clinicaDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "a_realizado", columnDefinition = "BOOLEAN")
    private boolean aRealizado;

    @Column(name = "datah", columnDefinition = "DATE")
    private LocalDate dataH;

    @Column(name = "nome", columnDefinition = "VARCHAR(255)")
    private String nome;

    @Column(name = "p_responsavel", columnDefinition = "VARCHAR(255)")
    private String pResponsavel;

    @Column(name = "telefone", columnDefinition = "VARCHAR(20)")
    private String telefone;
}

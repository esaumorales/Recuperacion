package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CLIENTE")
public class ClienteEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
@Column(name = "IDCLIENTE")
@SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize = 1, name = "seqCliente")
private Long id;

@Column(name = "DNI")
private int dni;

@Column(name = "NOMBRES")
private String nombres;

@Column(name = "APELLIDOS")
private String apellidos;

@Column(name = "TELEFONO")
private int telefono;

@Column(name = "EMAIL")
private String email;


@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
@JsonIgnore
private Set<ReservaEntity> reserva;
}
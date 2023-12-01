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
@Table(name="HOTEL")
public class HotelEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqHotel")
@Column(name = "IDHOTEL")
@SequenceGenerator(sequenceName = "SEQ_HOTEL", allocationSize = 1, name = "seqHotel")
private Long id;

@Column(name = "NOMBRE")
private String nombre;

@Column(name = "DIRECCION")
private String direccion;

@Column(name = "LOCALIDAD")
private String localidad;

@Column(name = "PROVINCIA")
private String provincia;

@Column(name = "TELEFONO")
private String telefono;

@Column(name = "NUMERO_ESTRELLAS")
private int numero_estrellas;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
@JsonIgnore
private Set<ReservaEntity> reserva;

}
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
@Table(name="VUELO")
public class VueloEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVuelo")
@Column(name = "IDVUELO")
@SequenceGenerator(sequenceName = "SEQ_VUELO", allocationSize = 1, name = "seqVuelo")
private Long id;

@Column(name = "FECHA_SALIDA")
private LocalDate fecha_salida;

@Column(name = "HORA_SALIDA")
private LocalDate hora_salida;

@Column(name = "FECHA_LLEGADA")
private LocalDate fecha_llegada;

@Column(name = "HORA_LLEGADA")
private LocalDate hora_llegada;

@Column(name = "ORIGEN")
private String origen;

@Column(name = "DESTINO")
private String destino;

@Column(name = "NUMERO_PLAZAS_TOTALES")
private String numero_plazas_totales;


@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vuelo")
@JsonIgnore
private Set<ReservaEntity> reserva;

}
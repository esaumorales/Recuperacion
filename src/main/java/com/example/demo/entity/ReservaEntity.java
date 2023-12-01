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
@Table(name="RESERVA")
public class ReservaEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReserva")
@Column(name = "IDRESERVA")
@SequenceGenerator(sequenceName = "SEQ_RESERVA", allocationSize = 1, name = "seqReserva")
private Long id;

@Column(name = "CLASE")
private String clase;


  	@ManyToOne
    @JoinColumn(name="IDVUELO", nullable = false)
    private VueloEntity vuelo;
  	
  	@ManyToOne
    @JoinColumn(name="IDCLIENTE", nullable = false)
    private ClienteEntity cliente;
  	
  	  	@ManyToOne
    @JoinColumn(name="IDHOTEL", nullable = false)
    private HotelEntity hotel;
  	  	
	@ManyToOne
    @JoinColumn(name="IDSURSAL", nullable = false)
    private SucursalEntity sucursal;

}

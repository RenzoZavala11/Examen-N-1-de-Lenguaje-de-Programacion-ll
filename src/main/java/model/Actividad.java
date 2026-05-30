package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_actividad")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Actividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_actividad")
	private Integer idActividad;
	
	@EqualsAndHashCode.Include
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name="nro_vacantes")
	private Integer nroVacantes;
	
	@Override
	public String toString() {
		return descripcion;
	}
}

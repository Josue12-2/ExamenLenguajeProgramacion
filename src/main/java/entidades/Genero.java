package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idgenero;

	private String nombre;

	public Genero() {
	}

	public int getIdgenero() {
		return this.idgenero;
	}

	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
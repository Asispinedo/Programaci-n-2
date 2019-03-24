package LN;

import COMUN.Constantes;

/**
 * Hereda todas las caracteristicas de la clase padre(clsPersonas) y ademas
 * tiene las propias como numeroSocio .Ademas la clase contiene los setters y
 * los getters propios ademas del constructor y una funcion tostring para poder
 * mostrar los datos del objeto
 **/

public class clsSocios extends clsPersonasClub {
	int numeroSocio;

	public clsSocios(String nombre, String apellido, int añoNacimiento, int id, int numeroSocio) {
		super(nombre, apellido, añoNacimiento, id);
		this.numeroSocio = numeroSocio;
	}

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {

		case Constantes.NOMBRE:
			return nombre;
		case Constantes.APELLIDO:
			return apellido;
		case Constantes.AÑONACIMIENTO:
			return añoNacimiento;
		case Constantes.NUMEROSOCIO:
			return numeroSocio;
		case Constantes.ID:
			return id;
		default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case Constantes.NUMEROSOCIO:
			numeroSocio = (int) valor;
			break;
		case Constantes.NOMBRE:
			nombre = (String) valor;
			break;
		case Constantes.APELLIDO:
			apellido = (String) valor;
			break;
		case Constantes.AÑONACIMIENTO:
			añoNacimiento = (int) valor;
			break;
		case Constantes.ID:
			id = (int) valor;
			break;
		}
	}
}
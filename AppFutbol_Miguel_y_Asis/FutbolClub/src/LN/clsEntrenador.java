package LN;

import COMUN.Constantes;

/** Hereda todas las caracteristicas de la clase padre(clsPersonas) y ademas tiene las propias como tipoEntrenador .Ademas la clase contiene los setters y los getters propios ademas del constructor y una funcion tostring para poder mostrar los datos del objeto **/

public class clsEntrenador extends clsPersonasClub implements Comparable<clsEntrenador>{
    String tipoEntrenador;

    public clsEntrenador(String nombre, String apellido, int aņoNacimiento, String tipoEntrenador, int id) {
        super(nombre, apellido, aņoNacimiento, id);
        this.tipoEntrenador = tipoEntrenador;

    }

    @Override
    public Object getObjectProperty(String propiedad) {
    	switch (propiedad) {
		case Constantes.NOMBRE:
			return nombre;
		case Constantes.APELLIDO:
			return apellido;
		case Constantes.AŅONACIMIENTO:
			return aņoNacimiento;
		case Constantes.TIPOENTRENADOR:
			return tipoEntrenador;
		case Constantes.ID:
			return id;
		default:
			return null;

		}
    }

    @Override
    public void setObjectProperty(String propiedad, Object valor) {
    	switch (propiedad) {
		case Constantes.TIPOENTRENADOR:
			tipoEntrenador = (String) valor;
			break;
		case Constantes.NOMBRE:
			nombre = (String) valor;
			break;
		case Constantes.APELLIDO:
			apellido = (String) valor;
			break;
		case Constantes.AŅONACIMIENTO:
			aņoNacimiento = (int) valor;
			break;
		case Constantes.ID:
			id = (int) valor;
			break;
    	}
    }

	@Override
	public int compareTo(clsEntrenador o) {
		Integer compare=(Integer) ((clsEntrenador)o).getObjectProperty(Constantes.ID);
        
        return compare-this.id;
	}
    
}

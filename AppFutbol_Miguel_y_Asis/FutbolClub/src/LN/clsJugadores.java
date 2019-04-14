package LN;



import COMUN.Constantes;

/**
 * Hereda todas las caracteristicas de la clase padre(clsPersonas) y ademas
 * tiene las propias como posicion .Ademas la clase contiene los setters y los
 * getters propios ademas del constructor y una funcion tostring para poder
 * mostrar los datos del objeto
 **/
public class clsJugadores extends clsPersonasClub implements Comparable<clsJugadores> {

	String posicion;

	public clsJugadores(String nombre, String apellido, int añoNacimiento, String posicion, int id) {
		super(nombre, apellido, añoNacimiento, id);
		this.posicion = posicion;

	}

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case Constantes.POSICION:
			return posicion;
		case Constantes.NOMBRE:
			return nombre;
		case Constantes.APELLIDO:
			return apellido;
		case Constantes.AÑONACIMIENTO:
			return añoNacimiento;
		case Constantes.ID:
			return id;
		default:
			return null;

		}
	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case Constantes.POSICION:
			posicion = (String) valor;
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

	@Override
	public int compareTo(clsJugadores arg0) {
		Integer compare=(Integer) ((clsJugadores)arg0).getObjectProperty(Constantes.ID);
        
        return compare-this.id;
	}
}
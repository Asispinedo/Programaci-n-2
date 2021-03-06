package LN;

import COMUN.Constantes;

/**
 * Hereda todas las caracteristicas de la clase padre(clsPersonas) y ademas tiene las propias como sueldo o tipo .Ademas la clase contiene los setters y los getters propios ademas del constructor y una funcion tostring para poder mostrar los datos del objeto
 **/

public class clsStaffs extends clsPersonasClub implements Comparable<clsStaffs> {
    public int sueldo;
    public String tipo;

    public clsStaffs(String nombre, String apellido, int sueldo, int aņoNacimiento, String tipo, int id) {
        super(nombre, apellido, aņoNacimiento, id);
        this.sueldo = sueldo;
        this.tipo = tipo;
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
		case Constantes.SUELDO:
			return sueldo;
		case Constantes.TIPOSTAFF:
			return tipo;
		case Constantes.ID:
			return id;
		default:
			return null;

		}
    }

    @Override
    public void setObjectProperty(String propiedad, Object valor) {
    	switch (propiedad) {
		case Constantes.TIPOSTAFF:
			tipo = (String) valor;
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
		case Constantes.SUELDO:
			sueldo = (int)valor;
			break;
    	}
    }

	@Override
	public int compareTo(clsStaffs o) {
		Integer compare=(Integer) ((clsStaffs)o).getObjectProperty(Constantes.ID);
        
        return compare-this.id;
	}
}

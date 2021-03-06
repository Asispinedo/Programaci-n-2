package LN;

import COMUN.ItfProperty;

/**
 * se crea lo que va a ser la clase "padre" para jugadores entrenadores staff y socios  y se crean los setters los getters y el constructor
 **/
public abstract class clsPersonasClub implements ItfProperty {
    String nombre;
    String apellido;
    int aņoNacimiento;
    int id;
    public boolean equals( Object o )
    {
        if( o instanceof clsPersonasClub )
        {
            if( ((clsPersonasClub) o).id==( id ) )
            {
                return true;
            }

                return false;
        }
        else
            return false;
    }


    public clsPersonasClub(String nombre, String apellido, int aņoNacimiento, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.aņoNacimiento = aņoNacimiento;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAņoNacimiento() {
        return aņoNacimiento;
    }

    public void setAņoNacimiento(int aņoNacimiento) {
        this.aņoNacimiento = aņoNacimiento;
    }

    public abstract Object getObjectProperty(String propiedad);

    public abstract void setObjectProperty(String propiedad, Object valor);
}

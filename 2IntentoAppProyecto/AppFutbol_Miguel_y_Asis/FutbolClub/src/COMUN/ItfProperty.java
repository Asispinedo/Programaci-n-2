package COMUN;


/**
 *
 */
/**
 * Interfaz para la independencia entre la LN y la LP.
 */
public interface ItfProperty
{
    Object getObjectProperty( String propiedad );
    void setObjectProperty( String propiedad , Object valor );
}


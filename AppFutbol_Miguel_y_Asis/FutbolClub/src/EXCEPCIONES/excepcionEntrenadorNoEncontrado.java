package EXCEPCIONES;

public class excepcionEntrenadorNoEncontrado extends Exception {

	public String getMessage() 
	{
		return "EL ENTRENADOR QUE BUSCAS NO SE ENCUENTRA PORQUE EL ID ES INCORRECTO!!!";
	}
}

package EXCEPCIONES;

public class excepcionJugadorNoEncontrado extends Exception {

	public String getMessage() 
	{
		return "EL JUGADOR QUE BUSCAS NO SE ENCUENTRA PORQUE EL ID ES INCORRECTO!!!";
	}
}

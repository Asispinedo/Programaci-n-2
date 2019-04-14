package EXCEPCIONES;

public class excepcionSocioNoEncontrado extends Exception {

	public String getMessage() 
	{
		return "EL SOCIO QUE BUSCAS NO SE ENCUENTRA PORQUE EL ID ES INCORRECTO!!!";
	}
}

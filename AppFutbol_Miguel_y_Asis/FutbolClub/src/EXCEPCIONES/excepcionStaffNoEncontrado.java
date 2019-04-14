package EXCEPCIONES;

public class excepcionStaffNoEncontrado extends Exception {

	public String getMessage() 
	{
		return "EL STAFF QUE BUSCAS NO SE ENCUENTRA PORQUE EL ID ES INCORRECTO!!!";
	}
}

package LP;

import COMUN.Constantes;
import COMUN.ItfProperty;
import EXCEPCIONES.excepcionEntrenadorRepe;
import EXCEPCIONES.excepcionJugadorNoEncontrado;
import EXCEPCIONES.excepcionJugadorRepe;
import EXCEPCIONES.excepcionSocioRepe;
import EXCEPCIONES.excepcionStaffRepe;
import LN.clsGestor;
import java.io.IOException;
import java.sql.SQLException;

public class clsMenu implements ItfProperty {
	/**
	 * La funcion que se va a encargar de mostrar el menu y concretar las opciones
	 * 
	 * @throws SQLException
	 * 
	 **/
	static char o;
	static int idJugadores;

	public char intento(char a) {

		return a;
	}

	public static void menuGeneral() throws IOException, SQLException, excepcionJugadorRepe, excepcionEntrenadorRepe,
			excepcionSocioRepe, excepcionStaffRepe, excepcionJugadorNoEncontrado {
		/**
		 * Se crea el objeto gestor que se encarga de gestionar el trafico de datos
		 * entre la logica de negocio y de la lógica de presentación.
		 **/
		char opcion;
		clsGestor objGestor = new clsGestor();
		objGestor.cargarDatos();
		char o2 = 'a';
		while (o2 == 'a') {
			System.out.println(
					"¿Que deseas hacer? \n" + "a)introducir\n" + "b)consultar\n" + "c)eliminar\n" + "d)modificar");
			opcion = clsUtilidadesLP.leerCaracter();
			// ventanaMenu vMenu = new ventanaMenu();
			// vMenu.setVisible(true);
			switch (opcion) {
			case 'a':
				System.out.println(
						"Que deseas introducir? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':

					vIntroducirJugadores vJug = new vIntroducirJugadores(objGestor);
					vJug.setVisible(true);
					break;
				case 'b':

					vIntroducirEntrenadores vEnt = new vIntroducirEntrenadores(objGestor);
					vEnt.setVisible(true);
					break;
				case 'c':

					vIntroducirStaffs vSt = new vIntroducirStaffs(objGestor);
					vSt.setVisible(true);
					break;
				case 'd':

					vIntroducirSocios vSoc = new vIntroducirSocios(objGestor);
					vSoc.setVisible(true);
					break;
				}
				break;
			case 'b':
				System.out.println(
						"Que deseas consultar? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':System.out.println("Ordenacion en funcion de el ID de manera:\n" + "a)Ascendente\n" + "b)Descendente");
						opcion = clsUtilidadesLP.leerCaracter();
					for (ItfProperty jugadores : objGestor.consultarJugadores(opcion)) {
						System.out.println("Nombre: " + jugadores.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + jugadores.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + jugadores.getObjectProperty(Constantes.AÑONACIMIENTO) + "  "
								+ "Posicion: " + jugadores.getObjectProperty(Constantes.POSICION) + "  " + "Id: "
								+ jugadores.getObjectProperty(Constantes.ID));
					}
					break;
				case 'b':
					System.out.println("Ordenacion en funcion de el ID de manera:\n" + "a)Ascendente\n" + "b)Descendente");
					opcion = clsUtilidadesLP.leerCaracter();
					for (ItfProperty entrenadores : objGestor.consultarEntrenadores(opcion)) {
						System.out.println("Nombre: " + entrenadores.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + entrenadores.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + entrenadores.getObjectProperty(Constantes.AÑONACIMIENTO)
								+ "  " + "Tipo de entrenador: "
								+ entrenadores.getObjectProperty(Constantes.TIPOENTRENADOR) + "  " + "Id: "
								+ entrenadores.getObjectProperty(Constantes.ID));
					}
					break;
				case 'c':
					System.out.println("Ordenacion en funcion de el ID de manera:\n" + "a)Ascendente\n" + "b)Descendente");
					opcion = clsUtilidadesLP.leerCaracter();
					for (ItfProperty staffs : objGestor.consultarStaffs(opcion)) {
						System.out.println("Nombre: " + staffs.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + staffs.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + staffs.getObjectProperty(Constantes.AÑONACIMIENTO) + "  "
								+ "Sueldo: " + staffs.getObjectProperty(Constantes.SUELDO) + "  " + "Tipo de Staff: "
								+ staffs.getObjectProperty(Constantes.TIPOSTAFF) + "  " + "Id: "
								+ staffs.getObjectProperty(Constantes.ID));
					}
					break;
				case 'd':
					System.out.println("Ordenacion en funcion de el ID de manera:\n" + "a)Ascendente\n" + "b)Descendente");
					opcion = clsUtilidadesLP.leerCaracter();
					for (ItfProperty socios : objGestor.consultarSocios(opcion)) {
						System.out.println("Nombre: " + socios.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + socios.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + socios.getObjectProperty(Constantes.AÑONACIMIENTO) + "  "
								+ "Numero de socio: " + socios.getObjectProperty(Constantes.NUMEROSOCIO) + "  " + "Id: "
								+ socios.getObjectProperty(Constantes.ID));
					}
					break;
				}
				break;
			case 'c':
				int id;

				System.out.println(
						"Que deseas borrar? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':
					System.out.println("Introduce el ID");
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.borrarJugadores(id)) {
						System.out.println("Se ha eliminado el jugador cuya id es " + id);
					}
					break;
				case 'b':
					System.out.println("Introduce el id");
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.borrarEntrenadores(id)) {
						System.out.println("Se ha eliminado el entrenador cuya id es " + id);

					} else
						System.out.println("No se ha podido eliminar");
					break;
				case 'c':
					System.out.println("Introduce el id");
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.borrarStaffs(id)) {
						System.out.println("Se ha eliminado el staff cuya id es " + id);

					} else
						System.out.println("No se ha podido eliminar");
					break;
				case 'd':
					System.out.println("Introduce el id");
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.borrarSocios(id)) {
						System.out.println("Se ha eliminado el socio cuya id es " + id);

					} else
						System.out.println("No se ha podido eliminar");
					break;
				}
				break;
			case 'd':

				System.out.println(
						"Que deseas modificar? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':
					System.out.println("       ¡RECUERDA!: \n" + "En jugadores solo se puede modificar la posicion");
					System.out.println("Introduce el id del jugador que quieres modificar:");
					id = clsUtilidadesLP.leerEntero();
					System.out.println("Introduce la nueva posicion del jugador seleccionado");
					String cambio = clsUtilidadesLP.leerCadena();
					if (objGestor.modificaPosicionJugadores(id, cambio) == true) {
						System.out.println("Se ha cambiado la posición del jugador a " + cambio + " correctamente");
					} else {
						System.out.println("NO SE HA PODIDO CAMBIAR LA POSICON");
					}
					break;
				case 'b':
					System.out.println("       ¡RECUERDA!: \n"
							+ "En entrenadores solo se puede modificar el tipo de entrenador (Primer entrenador, segundo entrenador o tercer entrenador)");
					System.out.println("Introduce el id del entrenador que quieres modificar:");
					id = clsUtilidadesLP.leerEntero();
					System.out.println("Introduce la nueva posicion del jugador seleccionado");
					cambio = clsUtilidadesLP.leerCadena();
					if (objGestor.modificaTipoEntrenador(id, cambio) == true) {
						System.out.println("Se ha cambiado el tipo del entrenador a " + cambio + " correctamente");
					} else {
						System.out.println("NO SE HA PODIDO CAMBIAR EL TIPO DE ENTRENADOR");
					}
					break;
				case 'c':
					System.out.println("               ¡RECUERDA!: \n"
							+ "En Staffs se puede modificar el sueldo y el tipo de staff, ¿cual de ambas desea modificar? \n"
							+ "a)Tipo de Staff\n" + "b)Sueldo");
					opcion = clsUtilidadesLP.leerCaracter();

					switch (opcion) {
					case 'a':
						System.out.println("Introduce el id del staff que quieres modificar:");
						id = clsUtilidadesLP.leerEntero();
						System.out.println("Introduce el nuevo tipo del staff seleccionado");
						cambio = clsUtilidadesLP.leerCadena();
						if (objGestor.modificaTipoStaff(id, cambio) == true) {
							System.out.println("Se ha cambiado el tipo del staff a " + cambio + " correctamente");
						} else {
							System.out.println("NO SE HA PODIDO CAMBIAR EL TIPO DE STAFF");
						}
						break;
					case 'b':
						System.out.println("Introduce el id del staff que quieres modificar:");
						id = clsUtilidadesLP.leerEntero();
						System.out.println("Introduce el nuevo sueldo del staff seleccionado");
						int sueldo = clsUtilidadesLP.leerEntero();
						if (objGestor.modificaSueldoStaff(id, sueldo) == true) {
							System.out.println("Se ha cambiado el sueldo de staff a " + sueldo + " correctamente");
						} else {
							System.out.println("NO SE HA PODIDO CAMBIAR EL SUELDO DE STAFF");
						}
						break;

					}
					break;
				case 'd':
					System.out.println(
							"         ¡RECUERDA!: \n" + "En Socios solo se puede modificar el numero de socio");
					System.out.println("Introduce el id del socio que quieres modificar:");
					id = clsUtilidadesLP.leerEntero();
					System.out.println("Introduce el nuevo numero de socio del socio seleccionado");
					int numsoc = clsUtilidadesLP.leerEntero();
					if (objGestor.modificaNumeroSocio(id, numsoc) == true) {
						System.out.println("Se ha cambiado el numero de socio a " + numsoc + " correctamente");
					} else {
						System.out.println("NO SE HA PODIDO CAMBIAR EL NUMERO DE SOCIO");
					}
					break;
				}
			}
			System.out.println("¿Deseas continuar?\n" + "respuestas posible:\n" + "a) si /  b) no");
			o2 = clsUtilidadesLP.leerCaracter();

		}
		System.out.println("FIN");

	}

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case Constantes.OPCION:
			return o;
		default:
			return null;
		}
	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		// TODO Auto-generated method stub

	}
}
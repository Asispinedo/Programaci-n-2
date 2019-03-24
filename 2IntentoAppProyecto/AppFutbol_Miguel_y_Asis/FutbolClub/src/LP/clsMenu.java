package LP;

import COMUN.Constantes;
import COMUN.ItfProperty;
import LN.clsGestor;
import java.io.IOException;
import java.sql.SQLException;

public class clsMenu {
	/**
	 * La funcion que se va a encargar de mostrar el menu y concretar las opciones
	 * 
	 * @throws SQLException
	 **/

	public static void menuGeneral() throws IOException, SQLException {
		/**
		 * Se crea el objeto gestor que se encarga de gestionar el trafico de datos
		 * entre la logica de negocio y de la lógica de presentación.
		 **/
		clsGestor objGestor = new clsGestor();
		char opcion;
		char o2 = 'a';
		while (o2 == 'a') {
			System.out.println(
					"¿Que deseas hacer? \n" + "a)introducir\n" + "b)consultar\n" + "c)eliminar\n" + "d)modificar");
			opcion = clsUtilidadesLP.leerCaracter();

			switch (opcion) {
			case 'a':
				System.out.println(
						"Que deseas introducir? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':
					System.out.println("Introduce sus datos (nombre, apellido, año de nacimiento, posicion y el id)");

					String nombre = clsUtilidadesLP.leerCadena();
					String apellido = clsUtilidadesLP.leerCadena();
					int añoNacimiento = clsUtilidadesLP.leerEntero();
					String posicion = clsUtilidadesLP.leerCadena();
					int id = clsUtilidadesLP.leerEntero();
					if (objGestor.introducirJugadores(nombre, apellido, añoNacimiento, posicion, id) == true) {
						System.out.println("Se ha añadido correctamente");
					} else
						System.out.println(
								"No se ha podido añadir debido a que has introducido un id ya ocupado (" + id + ")");
					break;
				case 'b':
					System.out.println(
							"Introduce sus datos (nombre, apellido, año de nacimiento, tipo de entrenador y el id)");
					nombre = clsUtilidadesLP.leerCadena();
					apellido = clsUtilidadesLP.leerCadena();
					añoNacimiento = clsUtilidadesLP.leerEntero();
					String tipoEntrenador = clsUtilidadesLP.leerCadena();
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.introducirEntrenadores(nombre, apellido, añoNacimiento, tipoEntrenador, id) == true) {
						System.out.println("Se ha añadido correctamente");
					} else
						System.out.println(
								"No se ha podido añadir debido a que has introducido un id ya ocupado (" + id + ")");
					break;
				case 'c':
					System.out
							.println("Introduce sus datos (nombre, apellido, año de nacimiento, sueldo, tipo y el id)");
					nombre = clsUtilidadesLP.leerCadena();
					apellido = clsUtilidadesLP.leerCadena();
					añoNacimiento = clsUtilidadesLP.leerEntero();
					int sueldo = clsUtilidadesLP.leerEntero();
					String tipoSocio = clsUtilidadesLP.leerCadena();
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.introducirStaffs(nombre, apellido, añoNacimiento, sueldo, tipoSocio, id) == true) {
						System.out.println("Se ha añadido correctamente");
					} else
						System.out.println(
								"No se ha podido añadir debido a que has introducido un id ya ocupado (" + id + ")");
					break;
				case 'd':
					System.out.println(
							"Introduce sus datos (nombre, apellido, año de nacimiento, numero de socio y el id)");
					nombre = clsUtilidadesLP.leerCadena();
					apellido = clsUtilidadesLP.leerCadena();
					añoNacimiento = clsUtilidadesLP.leerEntero();
					int numeroSocio = clsUtilidadesLP.leerEntero();
					id = clsUtilidadesLP.leerEntero();
					if (objGestor.introducirSocios(nombre, apellido, añoNacimiento, numeroSocio, id) == true) {
						System.out.println("Se ha añadido correctamente");
					} else
						System.out.println(
								"No se ha podido añadir debido a que has introducido un id ya ocupado (" + id + ")");
					break;
				}
				break;
			case 'b':
				System.out.println(
						"Que deseas consultar? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':
					for (ItfProperty jugadores : objGestor.consultarJugadores()) {
						System.out.println("Nombre: " + jugadores.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + jugadores.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + jugadores.getObjectProperty(Constantes.AÑONACIMIENTO) + "  "
								+ "Posicion: " + jugadores.getObjectProperty(Constantes.POSICION) + "  " + "Id: "
								+ jugadores.getObjectProperty(Constantes.ID));
					}
					break;
				case 'b':
					for (ItfProperty entrenadores : objGestor.consultarEntrenadores()) {
						System.out.println("Nombre: " + entrenadores.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + entrenadores.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + entrenadores.getObjectProperty(Constantes.AÑONACIMIENTO)
								+ "  " + "Tipo de entrenador: "
								+ entrenadores.getObjectProperty(Constantes.TIPOENTRENADOR) + "  " + "Id: "
								+ entrenadores.getObjectProperty(Constantes.ID));
					}
					break;
				case 'c':
					for (ItfProperty staffs : objGestor.consultarStaffs()) {
						System.out.println("Nombre: " + staffs.getObjectProperty(Constantes.NOMBRE) + "  "
								+ "Apellido: " + staffs.getObjectProperty(Constantes.APELLIDO) + "  "
								+ "Año de nacimiento: " + staffs.getObjectProperty(Constantes.AÑONACIMIENTO) + "  "
								+ "Sueldo: " + staffs.getObjectProperty(Constantes.SUELDO) + "  " + "Tipo de Staff: "
								+ staffs.getObjectProperty(Constantes.TIPOSTAFF) + "  " + "Id: "
								+ staffs.getObjectProperty(Constantes.ID));
					}
					break;
				case 'd':
					for (ItfProperty socios : objGestor.consultarSocios()) {
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

				System.out.println(
						"Que deseas borrar? \n" + "a)jugadores\n" + "b)entrenadores\n" + "c)staffs\n" + "d)socios");
				opcion = clsUtilidadesLP.leerCaracter();

				switch (opcion) {
				case 'a':
					System.out.println("Introduce el id");
					int id = clsUtilidadesLP.leerEntero();
					if (objGestor.borrarJugadores(id)) {
						System.out.println("Se ha eliminado el jugador cuya id es " + id);

					} else
						System.out.println("No se ha podido eliminar");
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
					int id = clsUtilidadesLP.leerEntero();
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
}
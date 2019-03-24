package LN;

import COMUN.Constantes;
import LD.clsEntrenadoresBD;
import LD.clsJugadoresBD;
import LD.clsSociosBD;
import LD.clsStaffsBD;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase gestor que se va a encargar de pasar datos de una lógica a
 * otra. Como ejemplo de la funcionalidad que va a tener esta clase está la
 * funcion de introducir jugadores aqunque posteriormente tendra todas las
 * posibilidades que muestra el menú
 **/
public class clsGestor {

	ArrayList<clsJugadores> listaJugadores;
	ArrayList<clsEntrenador> listaEntrenadores;
	ArrayList<clsSocios> listaSocios;
	ArrayList<clsStaffs> listaStaffs;

	public clsGestor() {
		listaJugadores = (ArrayList<clsJugadores>) clsJugadoresBD.cargarListaJugadores();
		listaEntrenadores = (ArrayList<clsEntrenador>) clsEntrenadoresBD.cargarListaEntrenadores();
		listaSocios = (ArrayList<clsSocios>) clsSociosBD.cargarListaSocios();
		listaStaffs = (ArrayList<clsStaffs>) clsStaffsBD.cargarListaStaffs();

	}

	public boolean buscarJugadores(clsJugadores obj) {
		int p = listaJugadores.indexOf(obj);

		if (p == -1)
			return false;
		else
			return true;
	}

	public boolean buscarEntrenadores(clsEntrenador obj) {
		int p = listaEntrenadores.indexOf(obj);

		if (p == -1)
			return false;
		else
			return true;
	}

	public boolean buscarSocios(clsSocios obj) {
		int p = listaSocios.indexOf(obj);

		if (p == -1)
			return false;
		else
			return true;
	}

	public boolean buscarStaffs(clsStaffs obj) {
		int p = listaStaffs.indexOf(obj);

		if (p == -1)
			return false;
		else
			return true;
	}

	public boolean introducirJugadores(String nombre, String apellido, int añoNacimiento, String puesto, int id) {
		// introducir un objeto de clsjugador en el arraylist
		clsJugadores objJugadores = new clsJugadores(nombre, apellido, añoNacimiento, puesto, id); // crea objeto

		if (buscarJugadores(objJugadores) == false) {
			listaJugadores.add(objJugadores); // añade el objeto al array

			clsJugadoresBD.buscarJugadores(id);
			if(clsJugadoresBD.introducirJugadores(nombre, apellido, añoNacimiento, puesto, id)==true) {

				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public boolean introducirEntrenadores(String nombre, String apellido, int añoNacimiento, String tipoEntrenador,
			int id) {
		clsEntrenador objEntrenadores = new clsEntrenador(nombre, apellido, añoNacimiento, tipoEntrenador, id);

		if (buscarEntrenadores(objEntrenadores) == false) {
			listaEntrenadores.add(objEntrenadores);

			clsEntrenadoresBD.buscarEntrenadores(id);
			if(clsEntrenadoresBD.introducirEntrenadores(nombre, apellido, añoNacimiento, tipoEntrenador, id)==true) {


			return true;
		} else {
			return false;}
		}else return false;
	}

	public boolean introducirStaffs(String nombre, String apellido, int añoNacimiento, int sueldo, String tipo,
			int id) {
		clsStaffs objStaffs = new clsStaffs(nombre, apellido, añoNacimiento, sueldo, tipo, id);
		if (buscarStaffs(objStaffs) == false) {
			listaStaffs.add(objStaffs);

			clsStaffsBD.buscarStaffs(id);
			if (clsStaffsBD.introducirStaffs(nombre, apellido, añoNacimiento, sueldo, tipo, id) == true) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public boolean introducirSocios(String nombre, String apellido, int añoNacimiento, int numeroSocio, int id) {
	
		clsSocios objSocios = new clsSocios(nombre, apellido, añoNacimiento, numeroSocio, id);
		
		if (buscarSocios(objSocios)==false) {
			listaSocios.add(objSocios);

			clsSociosBD.buscarSocios(id);
			if (clsSociosBD.introducirSocio(nombre, apellido, añoNacimiento, id, numeroSocio) == true) {

				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public boolean borrarJugadores(int id) {
		clsJugadores objJugadores = new clsJugadores(null, null, 0, null, id);
		if (buscarJugadores(objJugadores) == true) {
			listaJugadores.remove(objJugadores);
			if (clsJugadoresBD.borrarJugadores(id) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean borrarEntrenadores(int id) {
		clsEntrenador objEntrenadores = new clsEntrenador(null, null, 0, null, id);
		if (buscarEntrenadores(objEntrenadores) == true) {
			listaEntrenadores.remove(objEntrenadores);
			if (clsEntrenadoresBD.borrarEntrenadores(id) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean borrarStaffs(int id) {
		clsStaffs objStaffs = new clsStaffs(null, null, 0, 0, null, id);
		if (buscarStaffs(objStaffs) == true) {
			listaStaffs.remove(objStaffs);
			if (clsStaffsBD.borrarStaff(id) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean borrarSocios(int id) {
		clsSocios objSocios = new clsSocios(null, null, 0, id, 0);
		if (buscarSocios(objSocios) == true) {
			listaSocios.remove(objSocios);
			if (clsSociosBD.borrarSocios(id) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public List<clsJugadores> consultarJugadores() {
		List<clsJugadores> jugadores = new ArrayList<>();
		for (clsJugadores jugador : listaJugadores) {
			if (jugador instanceof clsJugadores) {
				jugadores.add(jugador);
			}
		}
		return jugadores;
	}

	public List<clsEntrenador> consultarEntrenadores() {
		List<clsEntrenador> entrenadores = new ArrayList<>();
		for (clsEntrenador entrenador : listaEntrenadores) {
			if (entrenador instanceof clsEntrenador) {
				entrenadores.add(entrenador);
			}
		}
		return entrenadores;
	}

	public List<clsSocios> consultarSocios() {
		List<clsSocios> socios = new ArrayList<>();
		for (clsSocios socio : listaSocios) {
			if (socio instanceof clsSocios) {
				socios.add(socio);
			}
		}
		return socios;
	}

	public List<clsStaffs> consultarStaffs() {
		List<clsStaffs> staffs = new ArrayList<>();
		for (clsStaffs staff : listaStaffs) {
			if (staff instanceof clsStaffs) {
				staffs.add(staff);
			}
		}
		return staffs;
	}

	public boolean modificaPosicionJugadores(int id, String posicion) {

		clsJugadores jugadorABuscar = new clsJugadores(null, null, 0, null, id);
		int p = listaJugadores.indexOf(jugadorABuscar);
		if (p != -1) {
			jugadorABuscar = (clsJugadores) listaJugadores.get(p);
			jugadorABuscar.setObjectProperty(Constantes.POSICION, posicion);
			if (clsJugadoresBD.cambiarPosicionJugadores(id, posicion) == true) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public boolean modificaTipoEntrenador(int id, String tipo) {

		clsEntrenador entrenadorABuscar = new clsEntrenador(null, null, 0, null, id);
		int p = listaEntrenadores.indexOf(entrenadorABuscar);
		if (p != -1) {
			entrenadorABuscar = (clsEntrenador) listaEntrenadores.get(p);
			entrenadorABuscar.setObjectProperty(Constantes.TIPOENTRENADOR, tipo);
			if (clsEntrenadoresBD.cambiarTipoEntrenador(id, tipo) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean modificaSueldoStaff(int id, int sueldo) {

		clsStaffs staffABuscar = new clsStaffs(null, null, 0, 0, null, id);
		int p = listaStaffs.indexOf(staffABuscar);
		if (p != -1) {
			staffABuscar = (clsStaffs) listaStaffs.get(p);
			staffABuscar.setObjectProperty(Constantes.SUELDO, sueldo);

			if (clsStaffsBD.cambiarSueldoStaffs(id, sueldo) == true) {
				return true;
			} else
				return false;

		} else
			return false;
	}

	public boolean modificaTipoStaff(int id, String tipo) {

		clsStaffs staffABuscar = new clsStaffs(null, null, 0, 0, null, id);
		int p = listaStaffs.indexOf(staffABuscar);
		if (p != -1) {
			staffABuscar = (clsStaffs) listaStaffs.get(p);
			staffABuscar.setObjectProperty(Constantes.TIPOSTAFF, tipo);
			if (clsStaffsBD.cambiarTipoStaffs(id, tipo) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean modificaNumeroSocio(int id, int numeroSocio) {

		clsSocios socioABuscar = new clsSocios(null, null, 0, id, 0);
		int p = listaSocios.indexOf(socioABuscar);
		if (p != -1) {
			socioABuscar = (clsSocios) listaSocios.get(p);
			socioABuscar.setObjectProperty(Constantes.NUMEROSOCIO, numeroSocio);
			if (clsSociosBD.cambiarNumeroSocios(id, numeroSocio) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}
}

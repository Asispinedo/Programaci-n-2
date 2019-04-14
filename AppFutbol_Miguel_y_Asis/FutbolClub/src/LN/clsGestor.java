package LN;

import COMUN.Constantes;
import EXCEPCIONES.excepcionEntrenadorNoEncontrado;
import EXCEPCIONES.excepcionEntrenadorRepe;
import EXCEPCIONES.excepcionJugadorNoEncontrado;
import EXCEPCIONES.excepcionJugadorRepe;
import EXCEPCIONES.excepcionSocioNoEncontrado;
import EXCEPCIONES.excepcionSocioRepe;
import EXCEPCIONES.excepcionStaffNoEncontrado;
import EXCEPCIONES.excepcionStaffRepe;
import LD.clsEntrenadoresBD;
import LD.clsJugadoresBD;
import LD.clsSociosBD;
import ORDENAR.compararEntrenadores;
import ORDENAR.compararJugadores;
import ORDENAR.compararSocios;
import ORDENAR.compararStaffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.sql.*;

/**
 * Esta es la clase gestor que se va a encargar de pasar datos de una lógica a
 * otra. Como ejemplo de la funcionalidad que va a tener esta clase está la
 * funcion de introducir jugadores aqunque posteriormente tendra todas las
 * posibilidades que muestra el menú
 **/
public class clsGestor {

	LD.clsStaffsBD objStaffsBD;
	LD.clsJugadoresBD objJugadoresBD;
	LD.clsSociosBD objSociosBD;
	LD.clsEntrenadoresBD objEntrenadoresBD;

	compararJugadores objCompararJ = new compararJugadores();
	compararEntrenadores objCompararE = new compararEntrenadores();
	compararSocios objCompararSo = new compararSocios();
	compararStaffs objCompararSt = new compararStaffs();

	private ArrayList<clsJugadores> listaJugadores = new ArrayList<clsJugadores>();
	private ArrayList<clsEntrenador> listaEntrenadores = new ArrayList<clsEntrenador>();
	private ArrayList<clsSocios> listaSocios = new ArrayList<clsSocios>();
	private ArrayList<clsStaffs> listaStaffs = new ArrayList<clsStaffs>();

	public clsGestor() {
		objStaffsBD = new LD.clsStaffsBD();
		objJugadoresBD = new clsJugadoresBD();
		objSociosBD = new clsSociosBD();
		objEntrenadoresBD = new clsEntrenadoresBD();
	}

	public boolean buscarJugadores(clsJugadores obj) {
		int p = listaJugadores.indexOf(obj);

		if (p == -1) {
			return false;
		} else
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

	public boolean buscarStaffs(clsStaffs obj) throws excepcionStaffRepe {
		int p = listaStaffs.indexOf(obj);

		if (p == -1)
			return false;
		else
			return true;
	}

	public void cargarDatos() {
		try {
			ResultSet rs = (ResultSet) objStaffsBD.cargarListaStaffs();
			while (rs.next()) {

				clsStaffs staff = new clsStaffs(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getInt("sueldo"), rs.getString("tipo"), rs.getInt("id"));
				listaStaffs.add(staff);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ResultSet rs = objJugadoresBD.cargarListaJugadores();
			clsJugadores jugador;

			System.out.println(listaJugadores);
			while (rs.next()) {

				jugador = new clsJugadores(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("añoNacimiento"),
						rs.getString("posicion"), rs.getInt("id"));
				listaJugadores.add(jugador);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ResultSet rs = objSociosBD.cargarListaSocios();
			while (rs.next()) {

				clsSocios socio = new clsSocios(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getInt("id"), rs.getInt("numeroSocio"));
				listaSocios.add(socio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ResultSet rs = (ResultSet) objEntrenadoresBD.cargarListaEntrenadores();
			while (rs.next()) {

				clsEntrenador entrenador = new clsEntrenador(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getString("tipoEntrenador"), rs.getInt("id"));
				listaEntrenadores.add(entrenador);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean introducirJugadores(String nombre, String apellido, int añoNacimiento, String posicion, int id)
			throws SQLException, excepcionJugadorRepe {
		// introducir un objeto de clsjugador en el arraylist
		excepcionJugadorRepe e = new excepcionJugadorRepe();
		clsJugadores objJugadores = new clsJugadores(nombre, apellido, añoNacimiento, posicion, id); // crea objeto

		if (buscarJugadores(objJugadores) == false) {
			listaJugadores.add(objJugadores); // añade el objeto al array

			ResultSet rs = objJugadoresBD.buscarJugadores(id);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				añoNacimiento = rs.getInt("añoNacimiento");
				posicion = rs.getString("posicion");
			}
			if (objJugadoresBD.introducirJugadores(nombre, apellido, añoNacimiento, posicion, id) == true) {

				return true;
			} else {

			}
		} else
			throw e;
		return false;
	}

	public boolean introducirEntrenadores(String nombre, String apellido, int añoNacimiento, String tipoEntrenador,
			int id) throws SQLException, excepcionEntrenadorRepe {

		excepcionEntrenadorRepe e = new excepcionEntrenadorRepe();
		clsEntrenador objEntrenadores = new clsEntrenador(nombre, apellido, añoNacimiento, tipoEntrenador, id);

		if (buscarEntrenadores(objEntrenadores) == false) {
			listaEntrenadores.add(objEntrenadores);

			ResultSet rs = objEntrenadoresBD.buscarEntrenadores(id);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				añoNacimiento = rs.getInt("añoNacimiento");
				tipoEntrenador = rs.getString("tipoEntrenador");
			}
			if (objEntrenadoresBD.introducirEntrenadores(nombre, apellido, añoNacimiento, tipoEntrenador, id) == true) {
				return true;
			} else {
			}
		} else
			throw e;
		return false;
	}

	public boolean introducirStaffs(String nombre, String apellido, int añoNacimiento, int sueldo, String tipo, int id)
			throws SQLException, excepcionStaffRepe {

		excepcionStaffRepe ex = new excepcionStaffRepe();

		clsStaffs objStaffs = new clsStaffs(nombre, apellido, añoNacimiento, sueldo, tipo, id);

		if (buscarStaffs(objStaffs) == false) {
			System.out.println("FUNCIONO");
			listaStaffs.add(objStaffs);

			ResultSet rs = objStaffsBD.buscarStaffs(id);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				añoNacimiento = rs.getInt("añoNacimiento");
				tipo = rs.getString("tipo");
				sueldo = rs.getInt("sueldo");

			}

			if (objStaffsBD.introducirStaffs(nombre, apellido, añoNacimiento, sueldo, tipo, id) == true) {
				return true;
			} else {
			}
		} else
			throw ex;
		return false;
	}

	public boolean introducirSocios(String nombre, String apellido, int añoNacimiento, int numeroSocio, int id)
			throws SQLException, excepcionSocioRepe {
		excepcionSocioRepe ex = new excepcionSocioRepe();
		clsSocios objSocios = new clsSocios(nombre, apellido, añoNacimiento, numeroSocio, id);

		if (buscarSocios(objSocios) == false) {
			listaSocios.add(objSocios);
			ResultSet rs = objSociosBD.buscarSocios(id);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				añoNacimiento = rs.getInt("añoNacimiento");
				numeroSocio = rs.getInt("numeroSocio");
			}

			if (objSociosBD.introducirSocio(nombre, apellido, añoNacimiento, id, numeroSocio) == true) {

				return true;
			} else {
			}
		} else
			throw ex;
		return false;
	}

	public boolean borrarJugadores(int id) throws excepcionJugadorRepe, excepcionJugadorNoEncontrado {

		excepcionJugadorNoEncontrado e = new excepcionJugadorNoEncontrado();
		clsJugadores objJugadores = new clsJugadores(null, null, 0, null, id);
		try {
			if (buscarJugadores(objJugadores) == true) {
				listaJugadores.remove(objJugadores);

				if (objJugadoresBD.borrarJugadores(id) == true) {
					return true;
				} else {
				}
			} else
				throw e;
		} catch (Exception exc) {
			String m = exc.getMessage();
			System.err.println(m);
		}
		return false;
	}

	public boolean borrarEntrenadores(int id) throws excepcionEntrenadorRepe {

		excepcionEntrenadorNoEncontrado excepcion = new excepcionEntrenadorNoEncontrado();
		clsEntrenador objEntrenadores = new clsEntrenador(null, null, 0, null, id);
		try {
			if (buscarEntrenadores(objEntrenadores) == true) {
				listaEntrenadores.remove(objEntrenadores);
				if (objEntrenadoresBD.borrarEntrenadores(id) == true) {
					return true;
				} else {
				}
			} else
				throw excepcion;
			return false;
		} catch (Exception exc) {
			String m = exc.getMessage();
			System.err.println(m);
		}
		return false;

	}

	public boolean borrarStaffs(int id) throws excepcionStaffRepe {
		clsStaffs objStaffs = new clsStaffs(null, null, 0, 0, null, id);
		excepcionStaffNoEncontrado excepcion = new excepcionStaffNoEncontrado();
		try {
			if (buscarStaffs(objStaffs) == true) {
				listaStaffs.remove(objStaffs);
				if (objStaffsBD.borrarStaff(id) == true) {
					return true;
				} else {
				}
			} else
				throw excepcion;
			return false;
		} catch (Exception exc) {
			String m = exc.getMessage();
			System.err.println(m);
		}
		return false;
	}

	public boolean borrarSocios(int id) throws excepcionSocioRepe {

		excepcionSocioNoEncontrado excepcion = new excepcionSocioNoEncontrado();
		clsSocios objSocios = new clsSocios(null, null, 0, id, 0);
		try {
			if (buscarSocios(objSocios) == true) {
				listaSocios.remove(objSocios);
				if (objSociosBD.borrarSocios(id) == true) {
					return true;
				} else {
				}
			} else
				throw excepcion;
			return false;
		} catch (

		Exception exc) {
			String m = exc.getMessage();
			System.err.println(m);
		}
		return false;
	}

	public List<clsJugadores> consultarJugadores(char opcion) {

		List<clsJugadores> jugadores = new ArrayList<>();

		for (clsJugadores jugador : listaJugadores) {
			if (jugador instanceof clsJugadores) {
				jugadores.add(jugador);
			}
		}
		if (opcion =='a'){
			Collections.sort(jugadores, objCompararJ);
		}else {
		Collections.sort(jugadores);
		}
		return jugadores;
	}

	public List<clsEntrenador> consultarEntrenadores(char opcion) {
		List<clsEntrenador> entrenadores = new ArrayList<>();
		for (clsEntrenador entrenador : listaEntrenadores) {
			if (entrenador instanceof clsEntrenador) {
				entrenadores.add(entrenador);
			}
		}
		if (opcion =='a'){
		Collections.sort(entrenadores, objCompararE);
		}else {
			Collections.sort(entrenadores);
			}
		return entrenadores;
	}

	public List<clsSocios> consultarSocios(char opcion) {
		List<clsSocios> socios = new ArrayList<>();
		for (clsSocios socio : listaSocios) {

			if (socio instanceof clsSocios) {
				socios.add(socio);
			}
		}if (opcion =='a'){
		Collections.sort(socios, objCompararSo);
		}else {
			Collections.sort(socios);
		}
		return socios;
	}

	public List<clsStaffs> consultarStaffs(char opcion) {
		List<clsStaffs> staffs = new ArrayList<>();
		for (clsStaffs staff : listaStaffs) {
			if (staff instanceof clsStaffs) {
				staffs.add(staff);
			}
		}if (opcion =='a'){
		Collections.sort(staffs, objCompararSt);
		}else {
			Collections.sort(staffs);
		}
		return staffs;
	}

	public boolean modificaPosicionJugadores(int id, String posicion) {

		clsJugadores jugadorABuscar = new clsJugadores(null, null, 0, null, id);
		int p = listaJugadores.indexOf(jugadorABuscar);
		if (p != -1) {
			jugadorABuscar = (clsJugadores) listaJugadores.get(p);
			jugadorABuscar.setObjectProperty(Constantes.POSICION, posicion);
			if (objJugadoresBD.cambiarPosicionJugadores(id, posicion) == true) {
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
			if (objEntrenadoresBD.cambiarTipoEntrenador(id, tipo) == true) {
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

			if (objStaffsBD.cambiarSueldoStaffs(id, sueldo) == true) {
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
			if (objStaffsBD.cambiarTipoStaffs(id, tipo) == true) {
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
			if (objSociosBD.cambiarNumeroSocios(id, numeroSocio) == true) {
				return true;
			} else
				return false;
		} else
			return false;
	}
}

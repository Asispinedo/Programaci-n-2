package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import LN.clsJugadores;
/**
 *  En esta clase como en todas las clases de ObjetosBd establecemos la conexion con el apartado de base de datos correspondiente en este caso la de Jugadores y tambiÃ©n estÃ¡n las clases que se van a encargar de introducir o borrar los jugadores o de modificar atributos propios de la clase como la posiciÃ³n  y tambien se va encargar  de ver si es posible mostrar jugadores, es decir si estÃ¡n en base de datos o no.
 */
public class clsJugadoresBD {

	public static List<clsJugadores> cargarListaJugadores() {
		ArrayList<clsJugadores> listaJugadoresBD = new ArrayList<>();

		try {
			// El codigo para acceder a una BDD deberá de ir entre un try - catch
			// Conectamos con la BDD
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = clsGestorBD.getInstance().createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Jugadores");

			// Tratamos los resultado de la anterior consulta
			while (rs.next()) {

				clsJugadores jugador = new clsJugadores(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getString("posicion"), rs.getInt("id"));
				listaJugadoresBD.add(jugador);
			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return listaJugadoresBD;
	}

	public static clsJugadores buscarJugadores(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Jugadores where id = '" + id + "'");

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int añoNacimiento = rs.getInt("añoNacimiento");
			String posicion = rs.getString("posicion");

			clsJugadores c = new clsJugadores(nombre, apellido, añoNacimiento, posicion, id);

			return c;
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}

	public static boolean existeJugadores(int id) {
		try {
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Jugadores where id = '" + id + "'");

			System.out.println("SELECT * FROM Jugadores where id = '" + id + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

			return false;
		}
	}

	public static boolean introducirJugadores(String nombre, String apellido, int añoNacimiento, String posicion,
			int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeJugadores(id);
			if (r == false) {
				String query = "insert into Jugadores values('" + nombre + "'" + ",'" + apellido + "','" + añoNacimiento
						+ "','" + posicion + "','" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			clsGestorBD.getInstance().disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}

	public static boolean borrarJugadores(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeJugadores(id);
			if (r == true) {
				String query = "delete from Jugadores where id =('" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			clsGestorBD.getInstance().disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}

	public static boolean cambiarPosicionJugadores(int id, String posicion) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeJugadores(id);
			if (r == true) {
				String query = "update jugadores set posicion=('" + posicion + "') where id=('" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			clsGestorBD.getInstance().disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}
}
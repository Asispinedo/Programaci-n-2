package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * En esta clase como en todas las clases de ObjetosBd establecemos la conexion
 * con el apartado de base de datos correspondiente en este caso la de Jugadores
 * y tambi√©n est√°n las clases que se van a encargar de introducir o borrar los
 * jugadores o de modificar atributos propios de la clase como la posici√≥n y
 * tambien se va encargar de ver si es posible mostrar jugadores, es decir si
 * est√°n en base de datos o no.
 */
public class clsJugadoresBD {

	clsGestorBD gbd = new clsGestorBD();

	public ResultSet cargarListaJugadores() {
		ResultSet rs = null;

		// El codigo para acceder a una BDD deber· de ir entre un try - catch
		// Conectamos con la BDD
		try {
			gbd.connect();
			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			rs = stmt.executeQuery("SELECT * FROM jugadores");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Tratamos los resultado de la anterior consulta
		return rs;
	}

	public ResultSet buscarJugadores(int id) {
	
		ResultSet rs = null;
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = sentencia.executeQuery("SELECT * FROM Jugadores where id = '" + id + "'");

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return rs;
	}

	public boolean existeJugadores(int id) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Jugadores where id = '" + id + "'");

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

	public boolean introducirJugadores(String nombre, String apellido, int aÒoNacimiento, String posicion, int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeJugadores(id);
			if (r == false) {
				String query = "insert into Jugadores values('" + nombre + "'" + ",'" + apellido + "','" + aÒoNacimiento
						+ "','" + posicion + "','" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}

	public boolean borrarJugadores(int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeJugadores(id);
			if (r == true) {
				String query = "delete from Jugadores where id =('" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}

	public boolean cambiarPosicionJugadores(int id, String posicion) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeJugadores(id);
			if (r == true) {
				String query = "update jugadores set posicion=('" + posicion + "') where id=('" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}
}
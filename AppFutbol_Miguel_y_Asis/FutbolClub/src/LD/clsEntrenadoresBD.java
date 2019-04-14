package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * En esta clase como en todas las clases de ObjetosBd establecemos la conexion
 * con el apartado de base de datos correspondiente en este caso la de
 * entrenadores y tambi√©n est√°n las clases que se van a encargar de introducir
 * o borrar los entrenadores modificar algunos de sus atributos como en este
 * caso de entrenadores el tipo de entrenador(Primero, Segundo, de Porteros...)
 * y tambien se va encargar de ver si es posible mostrar entrenadores, es decir
 * si est√°n en base de datos o no.
 */
public class clsEntrenadoresBD {

	clsGestorBD gbd = new clsGestorBD();

	public ResultSet cargarListaEntrenadores() { // preguntar si puedo quitar el import pasando por
													// parametros
		ResultSet rs = null;
		try {
			// El codigo para acceder a una BDD deber· de ir entre un try - catch
			// Conectamos con la BDD
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			rs = stmt.executeQuery("SELECT * FROM entrenadores");

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return rs;
	}

	/**
	 * Busca objetos Entrenador en base de datos
	 */
	public ResultSet buscarEntrenadores(int id) {
		ResultSet rs = null;
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = sentencia.executeQuery("SELECT * FROM entrenadores where id = '" + id + "'");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	/**
	 * Comprueba si hay o no objetos Entrenador en base de datos
	 */
	public boolean existeEntrenadores(int id) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM entrenadores where id = '" + id + "'");

			System.out.println("SELECT * FROM entrenadores where id = '" + id + "'");

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

	/**
	 * Introduce el objeto Entrenador en base de datos
	 */
	public boolean introducirEntrenadores(String nombre, String apellido, int aÒoNacimiento, String tipoEntrenador,
			int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeEntrenadores(id);
			if (r == false) {
				String query = "insert into entrenadores values('" + nombre + "'" + ",'" + apellido + "','"
						+ aÒoNacimiento + "','" + tipoEntrenador + "','" + id + "')";

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

	/**
	 * Elimina el objeto entrenador seleccionado de base de datos
	 *
	 *
	 */

	public boolean borrarEntrenadores(int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeEntrenadores(id);
			if (r == true) {
				String query = "delete from Entrenadores where id =('" + id + "')";

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

	/**
	 * Cambia el atributo Tipo de Entrenador
	 *
	 *
	 */
	public boolean cambiarTipoEntrenador(int id, String tipo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeEntrenadores(id);
			if (r == true) {
				String query = "update Entrenadores set tipoEntrenador=('" + tipo + "') where id=('" + id + "')";

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
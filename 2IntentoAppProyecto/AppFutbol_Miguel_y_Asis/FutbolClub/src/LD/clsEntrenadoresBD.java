package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import LN.clsEntrenador;

/**
 * En esta clase como en todas las clases de ObjetosBd establecemos la conexion
 *  con el apartado de base de datos correspondiente en este caso la de entrenadores 
 *  y tambiÃ©n estÃ¡n las clases que se van a encargar de introducir o borrar los 
 *  entrenadores modificar algunos de sus atributos como en este caso de entrenadores 
 *  el tipo de entrenador(Primero, Segundo, de Porteros...) y tambien se va encargar 
 *   de ver si es posible mostrar entrenadores, es decir si estÃ¡n en base de datos o no.
 */
public class clsEntrenadoresBD {

	public static List<clsEntrenador> cargarListaEntrenadores() {
		ArrayList<clsEntrenador> listaEntrenadoresBD = new ArrayList<>();

		try {
			// El codigo para acceder a una BDD deberá de ir entre un try - catch
			// Conectamos con la BDD
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = clsGestorBD.getInstance().createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			ResultSet rs = stmt.executeQuery("SELECT * FROM entrenadores");

			// Tratamos los resultado de la anterior consulta
			while (rs.next()) {

				clsEntrenador entrenador = new clsEntrenador(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getString("tipoEntrenador"), rs.getInt("id"));
				listaEntrenadoresBD.add(entrenador);
			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return listaEntrenadoresBD;
	}
	/**
	 * Busca objetos Entrenador en base de datos
	 */
	public static clsEntrenador buscarEntrenadores(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM entrenadores where id = '" + id + "'");

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int añoNacimiento = rs.getInt("añoNacimiento");
			String tipoEntrenador = rs.getString("tipoEntrenador");

			clsEntrenador c = new clsEntrenador(nombre, apellido, añoNacimiento, tipoEntrenador, id);

			return c;
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}
	/**
	 * Comprueba si hay o no objetos Entrenador en base de datos
	 */
	public static boolean existeEntrenadores(int id) {
		try {
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

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
	public static boolean introducirEntrenadores(String nombre, String apellido, int añoNacimiento,
			String tipoEntrenador, int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeEntrenadores(id);
			if (r == false) {
				String query = "insert into entrenadores values('" + nombre + "'" + ",'" + apellido + "','"
						+ añoNacimiento + "','" + tipoEntrenador + "','" + id + "')";

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
	/**
	 * Elimina el objeto entrenador seleccionado de base de datos
	 *
	 *
	 */

	public static boolean borrarEntrenadores(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeEntrenadores(id);
			if (r == true) {
				String query = "delete from Entrenadores where id =('" + id + "')";

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
	/**
	 * Cambia el atributo Tipo de Entrenador
	 *
	 *
	 */
	public static boolean cambiarTipoEntrenador(int id, String tipo) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeEntrenadores(id);
			if (r == true) {
				String query = "update entrenadores set tipo=('" + tipo + "') where id=('" + id + "')";

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

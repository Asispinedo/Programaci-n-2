/**
 * En esta clase como en todas las clases de ObjetosBd establecemos la conexion con el apartado de base de datos 
 * en este caso la de Socios y tambiÃ©n estÃ¡n las clases que se van a encargar de introducir o borrar los socios, 
 * en este caso de socios tambien de cambiar el nÃºmero de socio  y tambien se va encargar  de ver si es posible 
 * mostrar los Socios, es decir si estÃ¡n en base de datos o no.
 */
package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import LN.clsSocios;

public class clsSociosBD {

	public static List<clsSocios> cargarListaSocios() {
		ArrayList<clsSocios> listaSociosBD = new ArrayList<>();

		try {
			// El codigo para acceder a una BDD deberá de ir entre un try - catch
			// Conectamos con la BDD
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = clsGestorBD.getInstance().createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Socios");

			// Tratamos los resultado de la anterior consulta
			while (rs.next()) {

				clsSocios socio = new clsSocios(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getInt("id"), rs.getInt("numeroSocio"));
				listaSociosBD.add(socio);
			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return listaSociosBD;
	}

	public static clsSocios buscarSocios(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM socios where id = '" + id + "'");

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int añoNacimiento = rs.getInt("añoNacimiento");
			int numeroSocio = rs.getInt("numeroSocio");

			clsSocios c = new clsSocios(nombre, apellido, añoNacimiento, id, numeroSocio);

			return c;
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}

	public static boolean existeSocio(int id) {
		try {
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM socios where id = '" + id + "'");

			System.out.println("SELECT * FROM socios where id = '" + id + "'");

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

	public static boolean introducirSocio(String nombre, String apellido, int añoNacimiento, int id, int numeroSocio) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeSocio(id);
			if (r == false) {
				String query = "insert into socios values('" + nombre + "'" + ",'" + apellido + "','" + añoNacimiento
						+ "','" + id + "','" + numeroSocio + "')";

				sentencia.executeUpdate(query);
			} else {
				System.out.println("Socio Existente!");
				return false;
			}

			clsGestorBD.getInstance().disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}

	public static boolean borrarSocios(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeSocio(id);
			if (r == true) {
				String query = "delete from socios where id =('" + id + "')";

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

	public static boolean cambiarNumeroSocios(int id, int numeroSocio) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeSocio(id);
			if (r == true) {
				String query = "update socios set numeroSocio=('" + numeroSocio + "') where id=('" + id + "')";

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

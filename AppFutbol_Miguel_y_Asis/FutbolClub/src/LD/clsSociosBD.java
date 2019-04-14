/**
 * En esta clase como en todas las clases de ObjetosBd establecemos la conexion con el apartado de base de datos 
 * en este caso la de Socios y tambi√©n est√°n las clases que se van a encargar de introducir o borrar los socios, 
 * en este caso de socios tambien de cambiar el n√∫mero de socio  y tambien se va encargar  de ver si es posible 
 * mostrar los Socios, es decir si est√°n en base de datos o no.
 */
package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clsSociosBD {

	clsGestorBD gbd = new clsGestorBD();

	public ResultSet cargarListaSocios() {
		ResultSet rs = null;
		try {
			// El codigo para acceder a una BDD deber· de ir entre un try - catch
			// Conectamos con la BDD
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			rs = stmt.executeQuery("SELECT * FROM Socios");

			// Tratamos los resultado de la anterior consulta

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return rs;
	}

	public ResultSet buscarSocios(int id) {
		ResultSet rs = null;
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = sentencia.executeQuery("SELECT * FROM socios where id = '" + id + "'");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public boolean existeSocio(int id) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

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

	public boolean introducirSocio(String nombre, String apellido, int aÒoNacimiento, int id, int numeroSocio) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeSocio(id);
			if (r == false) {
				String query = "insert into socios values('" + nombre + "'" + ",'" + apellido + "','" + aÒoNacimiento
						+ "','" + id + "','" + numeroSocio + "')";

				sentencia.executeUpdate(query);
			} else {
				System.out.println("Socio Existente!");
				return false;
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}

	public boolean borrarSocios(int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeSocio(id);
			if (r == true) {
				String query = "delete from socios where id =('" + id + "')";

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

	public boolean cambiarNumeroSocios(int id, int numeroSocio) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeSocio(id);
			if (r == true) {
				String query = "update socios set numeroSocio=('" + numeroSocio + "') where id=('" + id + "')";

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

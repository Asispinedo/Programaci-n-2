package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clsStaffsBD {

	clsGestorBD gbd = new clsGestorBD();

	public ResultSet cargarListaStaffs() {
		ResultSet rs = null;

		// El codigo para acceder a una BDD deberá de ir entre un try - catch
		// Conectamos con la BDD
		try {
			gbd.connect();
			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			rs = stmt.executeQuery("SELECT * FROM staffs");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Tratamos los resultado de la anterior consulta
		return rs;

	}

	public ResultSet buscarStaffs(int id) throws SQLException {
		gbd.connect();
		ResultSet rs = null;
		try {

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = sentencia.executeQuery("SELECT * FROM staffs where id = '" + id + "'");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public boolean existeStaff(int id) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Staffs where id = '" + id + "'");

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

	public boolean introducirStaffs(String nombre, String apellido, int añoNacimiento, int sueldo, String tipo,
			int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == false) {
				String query = "insert into staffs values('" + nombre + "'" + ",'" + apellido + "','" + añoNacimiento
						+ "','" + sueldo + "','" + tipo + "','" + id + "')";

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

	public boolean borrarStaff(int id) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == true) {
				String query = "delete from staffs where id =('" + id + "')";

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

	public boolean cambiarSueldoStaffs(int id, int sueldo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == true) {
				String query = "update staffs set sueldo=('" + sueldo + "') where id=('" + id + "')";

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

	public boolean cambiarTipoStaffs(int id, String tipo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == true) {
				String query = "update staffs set tipo=('" + tipo + "') where id=('" + id + "')";

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

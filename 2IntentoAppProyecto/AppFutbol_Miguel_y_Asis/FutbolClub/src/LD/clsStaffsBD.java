package LD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import LN.clsStaffs;

public class clsStaffsBD {

	public static List<clsStaffs> cargarListaStaffs() {
		ArrayList<clsStaffs> listaStaffsBD = new ArrayList<>();

		try {
			// El codigo para acceder a una BDD deberá de ir entre un try - catch
			// Conectamos con la BDD
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = clsGestorBD.getInstance().createStatement();

			// seleccionamos la tabla Jugadorese de la BDD
			ResultSet rs = stmt.executeQuery("SELECT * FROM staffs");

			// Tratamos los resultado de la anterior consulta
			while (rs.next()) {

				clsStaffs staff = new clsStaffs(rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("añoNacimiento"), rs.getInt("sueldo"), rs.getString("tipo"), rs.getInt("id"));
				listaStaffsBD.add(staff);
			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return listaStaffsBD;
	}

	public static clsStaffs buscarStaffs(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM staffs where id = '" + id + "'");

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int añoNacimiento = rs.getInt("añoNacimiento");
			String tipo = rs.getString("tipo");
			int sueldo = rs.getInt("sueldo");

			clsStaffs c = new clsStaffs(nombre, apellido, añoNacimiento, sueldo, tipo, id);

			return c;
		} catch (SQLException ex) {
			ex.printStackTrace();

			return null;
		}
	}

	public static boolean existeStaff(int id) {
		try {
			clsGestorBD.getInstance().connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Staffs where id = '" + id + "'");

			System.out.println("SELECT * FROM staffs where id = '" + id + "'");

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

	public static boolean introducirStaffs(String nombre, String apellido, int añoNacimiento, int sueldo, String tipo,
			int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == false) {
				String query = "insert into staffs values('" + nombre + "'" + ",'" + apellido + "','" + añoNacimiento
						+ "','" + sueldo + "','" + tipo + "','" + id + "')";

				sentencia.executeUpdate(query);
			} else {
				return false;
			}

			clsGestorBD.getInstance().disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}return true;
	}

	public static boolean borrarStaff(int id) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == true) {
				String query = "delete from staffs where id =('" + id + "')";

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

	public static boolean cambiarSueldoStaffs(int id, int sueldo) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == true) {
				String query = "update staffs set sueldo=('" + sueldo + "') where id=('" + id + "')";

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

	public static boolean cambiarTipoStaffs(int id, String tipo) {
		try {
			clsGestorBD.getInstance().connect();

			Statement sentencia = clsGestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			boolean r = existeStaff(id);
			if (r == true) {
				String query = "update staffs set tipo=('" + tipo + "') where id=('" + id + "')";

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

package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajero;

public class DaoPasajeroMySql implements DaoPasajero {

	private DaoMySql conectar = new DaoMySql();
	private Connection conexion;

	@Override
	public boolean anadir(Pasajero p) {
		/**
		 * Metodo para añadir un pasajero a BBDD
		 * 
		 * @param p El objeto pasajero que se desea añadir
		 * @return devuelve booleano en caso de agregar true
		 */
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return false;
		}
		boolean alta = false;
		String query = "insert into pasajeros (NOMBRE,EDAD,PESO)" + "values(?,?,?)";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setFloat(3, p.getPeso());
			alta = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return alta;
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return false;
		}
		boolean borrar = false;
		String query = "Delete from pasajeros where id = ?";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setInt(1, id);
			ps.executeUpdate();
			borrar = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return borrar;
	}

	@Override
	public Pasajero consultar(int id) {
		// TODO Auto-generated method stub
		boolean consultar = true;
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return null;
		}
		Pasajero p = new Pasajero();
		String query = "select * from pasajeros where id=?";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p.setId_pasajero(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getFloat(id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public boolean modificar(Pasajero p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pasajero> listar() {
		// TODO Auto-generated method stub
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return null;
		}
		List<Pasajero> pasajeros = new ArrayList<>();
		String query = "SELECT id,nombre,edad,peso FROM pasajeros";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pasajero p = new Pasajero();
				p.setId_pasajero(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

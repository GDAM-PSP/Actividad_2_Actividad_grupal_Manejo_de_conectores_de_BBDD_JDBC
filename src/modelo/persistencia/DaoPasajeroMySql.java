package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajero;

public class DaoPasajeroMySql implements DaoPasajero {

	private DaoMySql conectar = new DaoMySql();
	private Connection conexion;

	@Override
	/**
	 * Metodo para insertar un pasajero realizando conexion a BBDD
	 * 
	 * @param p El objeto pasajero que se desea añadir
	 * @return true/false>> si se ha agregado con exito.
	 */

	public boolean agregar(Pasajero p) {
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return false;
		}
		boolean alta = false;
		String query = "INSERT INTO pasajero (NOMBRE,EDAD,PESO)" + "values(?,?,?)";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setFloat(3, p.getPeso());
			alta = true;
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return alta;
	}

	@Override
	/**
	 * Metodo para borrar un pasajero realizando conexion a BBDD
	 * 
	 * @param id El objeto pasajero que se desea borrar
	 * @return true/false>> si se ha borrado con exito.
	 */
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return false;
		}
		boolean borrar = false;
		String query = "DELETE FROM pasajero WHERE id = ?";
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
	/**
	 * Metodo para consultar un pasajero realizando conexion a BBDD
	 * 
	 * @param id El objeto pasajero que se desea consultar
	 * @return Pasajero>> develve objeto consultado.
	 */
	public Pasajero consultar(int id) {
		// TODO Auto-generated method stub
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return null;
		}
		Pasajero p = new Pasajero();
		String query = "SELECT * FROM pasajero WHERE id=?";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p.setId_pasajero(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

//	@Override
//	/**
//	 * Metodo para modificar un pasajero realizando conexion a BBDD
//	 * 
//	 * @param p El objeto pasajero que se desea modificar
//	 * @return true/false>> si se ha modificado con exito.
//	 */

//	public boolean modificar(Pasajero p) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	/**
	 * Metodo para listar los pasajeros realizando conexion a BBDD
	 * 
	 * @return List>> devuelve lista de pasajeros
	 */
	public List<Pasajero> listar() {
		// TODO Auto-generated method stub
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return null;
		}
		List<Pasajero> pasajeros = new ArrayList<>();
		String query = "SELECT * FROM pasajero";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pasajero p = new Pasajero();
				p.setId_pasajero(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getFloat(4));
				pasajeros.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasajeros;
	}

	@Override

	/**
	 * Metodo para asignar un pasajero a un coche en BBDD
	 * 
	 * @param id_pasajero ID del pasajero a asignar
	 * @param id_coche    ID del coche a asignar
	 * @return true/false>> Devuelve boolean si consigue asignar el pasajero
	 */
	public boolean asignar(int id_pasajero, int id_coche) {
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return false;
		}
		String query = "UPDATE `pasajero` SET `id_coche`=? WHERE `id`=?";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setInt(1, id_coche);
			ps.setInt(2, id_pasajero);
			int count = ps.executeUpdate();
			return (count > 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo para listar los pasajeros asociados al coche seleccionado
	 * 
	 * @param id_coche ID del coche para visualizar pasajeros asociados
	 * @return List>> Devuelve lista de pasajeros asociados
	 */
	public List<Pasajero> listar_asignado(int id_coche) {
		// TODO Auto-generated method stub
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return null;
		}
		List<Pasajero> pasajeros_asignado = new ArrayList<>();
		String query = "SELECT id,nombre FROM pasajero WHERE `id_coche`=?";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setInt(1, id_coche);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pasajero p = new Pasajero();
				p.setId_pasajero(rs.getInt(1));
				p.setNombre(rs.getString(2));
				pasajeros_asignado.add(p);
			}
			return pasajeros_asignado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasajeros_asignado;
	}

	@Override

	/**
	 * Metodo para desasignar los pasajeros
	 * 
	 * @param id_coche ID del coche para visualizar pasajeros asignados
	 * @return List>> Devuelve lista de pasajeros // coches asignados
	 */
	public boolean desasignar(int id_pasajero) {

		// SOLO VAMOS A MOSTRAR COCHES CON PASAJEROS

		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return false;
		}
		String query = "UPDATE `pasajero` SET `id_coche`=NULL WHERE `id`=?";
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ps.setInt(1, id_pasajero);
			int count = ps.executeUpdate();
			return (count > 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Pasajero> listar_asignados_coche() {
		conexion = conectar.abrirConexion(conexion);
		if (conexion == null) {
			return null;
		}
		List<Pasajero> pasajeros_asignados = new ArrayList<>();
		String query = "SELECT * FROM pasajero WHERE id_coche IS NOT NULL";
		
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pasajero p = new Pasajero();
				p.setId_pasajero(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setEdad(rs.getInt(3));
				p.setPeso(rs.getFloat(4));
				p.setId_coche(rs.getInt(5));
				pasajeros_asignados.add(p);
			}

			return pasajeros_asignados;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pasajeros_asignados;
	}
}

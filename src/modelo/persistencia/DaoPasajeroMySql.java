package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;

public class DaoPasajeroMySql implements DaoPasajero {

	private DaoMySql conectar = new DaoMySql();
	private Connection conexion;

	//añade el coche con los datos proporcionados y crea automaticamente un id que no existe
	@Override
	public boolean anadir(Pasajero p) {
		
		conexion = conectar.abrirConexion(conexion);
		
		if(conexion == null){
			return false;
		}
		
		boolean alta = true;
		String query = "insert into pasajero (NOMBRE,EDAD,PESO, id_coche)"
				+ "values(?,?,?,?,?)";
		try {			
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setFloat(3, p.getPeso());
			ps.setInt(4, p.getId_coche());
			int numeroFilasAfectadas = ps.executeUpdate();
			
			//si se han echo cambios devolvera mas de 0 filas  
			if(numeroFilasAfectadas==0) {
				alta = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			conectar.cerrarConexion(conexion);
		}
		
		
		return alta;
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pasajero consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Pasajero p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pasajero> listar() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}

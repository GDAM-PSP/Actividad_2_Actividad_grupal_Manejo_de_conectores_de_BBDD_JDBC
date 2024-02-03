package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.configuracion.Configuracion;
import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche{

	private DaoMySql conectar = new DaoMySql();
	private Connection conexion;

	//añade el coche con los datos proporcionados y crea automaticamente un id que no existe
	@Override
	public boolean anadir(Coche c) {
		
		conexion = conectar.abrirConexion(conexion);
		
		if(conexion == null){
			return false;
		}
		
		boolean alta = true;
		String query = "insert into coches (MARCA,MODELO,AÑO,KM)"
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setInt(3, c.getAnio());
			ps.setInt(4, c.getKm());
			
			//si se han echo cambios devolvera mas de 0 filas  
			int numeroFilasAfectadas = ps.executeUpdate();
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
	//borra el coche con el id que le mandas
	@Override
	public boolean borrar(int id) {

		conexion = conectar.abrirConexion(conexion);
		
		if(conexion == null){
			return false;
		}
		
		boolean borrar = true;
		String query = "Delete from coches where id = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			//si se han echo cambios devolvera mas de 0 filas  
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas==0) {
				borrar = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conectar.cerrarConexion(conexion);
		}
		return borrar;
	}
	//consulta el coche que le mandes buscando su id
	@Override
	public Coche consultar(int id) {
		
		conexion = conectar.abrirConexion(conexion);
		
		if(conexion == null){
			return null;
		}
		
		boolean consultar = true;
		String query = "select * from coches where id=?";
		Coche c = null;
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			//mientras haya resultados en la consulta se ejecutara esta linea de codigo
			while(rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setAnio(rs.getInt(4));
				c.setKm(rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conectar.cerrarConexion(conexion);
		}
		
		
		return c;
	}
	//modifica el objeto que le mandes segun el id que lo usa como buscador
	@Override
	public boolean modificar(Coche c) {
		
		conexion = conectar.abrirConexion(conexion);
		
		if(conexion == null){
			return false;
		}
	    
	    boolean modificado = true;
	    String query = "UPDATE `coches` SET `marca`=?, `modelo`=?, `año`=?, `km`=? WHERE `id`=?";
	    
	    try {
	        PreparedStatement pr = conexion.prepareStatement(query);
	        pr.setString(1, c.getMarca());
	        pr.setString(2, c.getModelo());
	        pr.setInt(3, c.getAnio());
	        pr.setInt(4, c.getKm());
	        pr.setInt(5, c.getId());
	        
	        //si se han echo cambios devolvera mas de 0 filas  
	        int numeroFilasAfectadas = pr.executeUpdate();
	        if (numeroFilasAfectadas == 0) {
	            modificado = false;
	        }

	    } catch (SQLException e) {
	        System.out.println("modificar -> error al modificar el coche " + c);
	        System.out.println(query);
	        e.printStackTrace();
	        modificado = false;
	    } finally {
	    	conectar.cerrarConexion(conexion);
	    }

	    return modificado;
	}
	//Lista todos los objetos coche que hay en la base de datos
	@Override
	public List<Coche> listar() {

		conexion = conectar.abrirConexion(conexion);
		
		if(conexion == null){
			return null;
		}
		
		List<Coche> coches = new ArrayList<>();
		String query = "SELECT ID,MARCA,MODELO,AÑO,KM FROM coches";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			//mientras haya resultados en la consulta se ejecutara esta linea de codigo
			while(rs.next()) {
				Coche c = new Coche();
				c.setId(rs.getInt(1));
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setAnio(rs.getInt(4));
				c.setKm(rs.getInt(5));

				coches.add(c);
			}
			
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		}
		
		
		return coches;
	}

	

}

package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author 
 * Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */

public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Función que permite insertar un vehiculo en la Base de datos.
     * @param newVehicle
     * @return true cuando inserta correctamente, en caso contrario @return false
     */
    public boolean save(Vehicle newVehicle) {
        try {
            //Validate vehicle
            
            if (newVehicle == null || newVehicle.getPlate().isEmpty() || newVehicle.getType().toString().isEmpty()) {
                return false;
            }
            String sql = "INSERT INTO VehicleBD ( Plate, Type) "
                    + "VALUES ( ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setObject(2, newVehicle.getType()); 
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    /**
     * Función que obtiene los vehiculos de la base de datos
     * @return lista de vehiculos
     */
    public List<Vehicle> list() {
        List<Vehicle> vehiculos = new ArrayList<>();
        try {

            String sql = "SELECT Plate, Type FROM VehicleBD";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle varVehicle = new Vehicle();
                varVehicle.setPlate(rs.getString("Plate"));
                varVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));
                vehiculos.add(varVehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }
    
    /**
     * Creación de la base de datos y la tabla en memoria
     */
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS VehicleBD (\n"
                + "	Plate text PRIMARY KEY,\n"
                + "      Type varchar2 NOT NULL)";
        Statement stmt = null;
        try {
            this.connect();
            stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conexión de la base de datos con la aplicación
     */
    public void connect() {
       
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Desconexión de la base de datos con la aplicación
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

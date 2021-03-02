package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;


/**
 * Interfaz de vehiculo
 * @author 
 * Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */

public interface IVehicleRepository {

    /**
     *
     * @param newVehiculo
     * @return
     */
    boolean save(Vehicle newVehiculo);

    /**
     *
     * @return
     */
    List<Vehicle> list();
    
    
}

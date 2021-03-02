
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * @author 
 * Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public interface IParkingCost {
    
    public long calculateCost(Vehicle prmVehicle, LocalDateTime input, LocalDateTime output);
}

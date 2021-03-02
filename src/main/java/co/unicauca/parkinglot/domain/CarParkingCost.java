package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author 
 * Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904 
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public class CarParkingCost implements IParkingCost {

  
    /**
     * Función que calcula el total a pagar del parqueadero de un Carro
     * @param prmVehicle
     * @param input
     * @param output
     * @return 
     */
    
    @Override
    public long calculateCost(Vehicle prmVehicle, LocalDateTime input, LocalDateTime output) {
       
        double varValorPagar =0;
        double varCostoAdicional = 0;
        long varMin = (int) ChronoUnit.MINUTES.between(input, output);

        if (varMin <= 60) {
            return (long) 2000;
        } else {
            varCostoAdicional = ((1000 * (varMin-60))/60);     
            varValorPagar = Math.ceil(((2000+varCostoAdicional)/100))*100; 
            return (long) varValorPagar; 

        }

    }
}

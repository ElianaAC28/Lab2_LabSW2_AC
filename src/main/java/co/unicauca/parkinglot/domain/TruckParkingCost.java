package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public class TruckParkingCost implements IParkingCost {

    /**
     * Función que calcula el total a pagar del parqueadero de un Camión
     * @param prmVehicle
     * @param input
     * @param output
     * @return
     */
    @Override
    public long calculateCost(Vehicle prmVehicle, LocalDateTime input, LocalDateTime output) {
        
        double varValorTotal;
        double varHora = ChronoUnit.HOURS.between(input, output);

        if (sorteoTarifa((int) (Math.random() * 1000 + 1))) {
            System.out.println("FELICITACIONES, NO DEBE PAGAR NADA ");
            return 0;
        } else {
            if (varHora <= 12) {
                return 10000;
            } else if (varHora > 12 && varHora <= 24) {
                return 15000;
            } else {
                varHora= varHora*625;
                
                varValorTotal = Math.ceil((varHora/100));
                return (long) (varValorTotal*100);
            }
        }

    }

    private boolean sorteoTarifa(int parNumero) {
        int varNumero = (int) (Math.random() * 1000 + 1);
        return parNumero == varNumero;
    }
}

package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * @author 
 * Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904 
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public class ParkingCostFactory {

    private static ParkingCostFactory instance;
    private Map<TypeEnum, IParkingCost> dictionary;

    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
    
    /**
     * Función que instancia la clase ParkingFactory
     * 
     */
    ParkingCostFactory getinstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();                    
        }
        return instance;
    }
    
    /**
     * Función que determina el tipo de vehiculo 
     * para calcular el valor del parquedaero
     *
     */
    
    IParkingCost getParkingCost(TypeEnum veh) {
        IParkingCost varResultado = null;
        if (dictionary.containsKey(veh)) {
            varResultado = dictionary.get(veh);
        }
        return varResultado;
    }

}

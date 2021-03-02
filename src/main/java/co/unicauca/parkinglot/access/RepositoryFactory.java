package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Fabrica que se encarga de instanciar VehicleRepository o cualquier otro que
 * se cree en el futuro.
 *
 * @author Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /**
     * Método que crea una instancia concreta de la jerarquia IVehicleRepository
     *
     * @param typeEnum cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IVehicleRepository
     */

    public static IVehicleRepository getRepository(String typeEnum) {

        IVehicleRepository result = null;

        switch (typeEnum) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;
    }

}

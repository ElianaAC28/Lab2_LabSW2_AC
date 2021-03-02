package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.access.VehicleRepository;
import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio es la clase que concentra la lógica de negocio
 * @author 
 * Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904 
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public class Service {

    
    private IVehicleRepository repository;

    public Service() {
        repository = new VehicleRepository();
    }

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Función que instancia de acuerdo al vehiculo 
     * @return varTarifa dependiendo del tipo de Vehiculo
     *
     */
    long varTarifa =0;
    public long calculateParkingCost(Vehicle prmVehicle, LocalDateTime input, LocalDateTime output) {
      
        if (prmVehicle.getType() == TypeEnum.CAR) {
            CarParkingCost varCar = new CarParkingCost();
            varTarifa = varCar.calculateCost(prmVehicle, input, output);
            
            return varTarifa;

        } if (prmVehicle.getType() == TypeEnum.MOTO) {
           
            MotoParkingCost varMoto = new MotoParkingCost();
            varTarifa = varMoto.calculateCost(prmVehicle, input, output);
            
            return varTarifa;
       
        } if (prmVehicle.getType() == TypeEnum.TRUCK) {
            TruckParkingCost varTruck = new TruckParkingCost();
            varTarifa = varTruck.calculateCost(prmVehicle, input, output);
            
            return varTarifa;
        }
        return 0;   

    }

    /**
     * Guardar un vehiculo
     * @param newVehicle
     * @return false si algún campo esta vacío, de lo contrario
     * se guarda correctamente y @return true
     */
    public boolean saveVehicle(Vehicle newVehicle) {
        //Validate vehicle
        if (newVehicle == null || newVehicle.getPlate().isEmpty() || newVehicle.getType().toString().isEmpty()) {
            return false;
        }
        repository.save(newVehicle);
        return true;
    }

    /**
     * Creación de Lista de vehiculos
     * @return lista de vehiculos-->vehiculos
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehiculos = new ArrayList<>();
        vehiculos = repository.list();
        return vehiculos;
    }

}

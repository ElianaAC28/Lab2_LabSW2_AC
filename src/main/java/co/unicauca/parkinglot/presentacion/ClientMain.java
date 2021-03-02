package co.unicauca.parkinglot.presentacion;

import co.unicauca.parkinglot.access.IVehicleRepository;

import co.unicauca.parkinglot.access.RepositoryFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.service.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import static junit.framework.Assert.assertEquals;

/**
 * @author Luis Manuel Arroyo luisarroyo@unicauca.edu.co 104617010904 
 * Eliana Camayo eacamayo@unicauca.edu.co 104616021725
 */
public class ClientMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        //Creación de vehiculo tipo Moto
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        
        //Información sobre el rango de tiempo que estuvo en el parqueadero
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);
        
        //Definición del repositorio por defecto
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        
        //Instancia de la clase Service
        Service service = new Service(repo); 
        
        //Llamado al método calculateParkingCost y  almacenado en la variable result tipo long
        long result = service.calculateParkingCost(veh, input, output);
        
        //Impresión
        System.out.println("Valor a pagar por la moto: " + result);
        
        //Guarda el vehiculo
        service.saveVehicle(veh);
        
        //Creación de un vehiculo tipo Carro
        veh = new Vehicle("JNK-124", TypeEnum.CAR);
        
        //Guarda el vehiculo
        service.saveVehicle(veh);
        
        //Impresión de la información respectiva de la Moto y el Carro
        List<Vehicle> list = service.listVehicles();
        list.forEach(vehicle -> {
            System.out.println(vehicle.toString());
        });


    }
}

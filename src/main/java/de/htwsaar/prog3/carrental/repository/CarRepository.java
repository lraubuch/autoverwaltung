package de.htwsaar.prog3.carrental.repository;

import de.htwsaar.prog3.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    boolean existsByIdNotAndVin(Long id, String vin);

    boolean existsByIdNotAndLicenseNumber(Long id, String licenseNumber);

    boolean existsByIdNotAndParkingLot(Long id, String parkingLot);
}

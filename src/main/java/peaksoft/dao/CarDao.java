package peaksoft.dao;

import peaksoft.model.Car;
public interface CarDao {
    void createTables();
    void deleteById(Long id);
    void saveCar(Car car);

}

package peaksoft.dao;

import peaksoft.model.Garage;

public interface GarageDao {
    void createTables();
    void deleteById(Long id);
    void saveGarage(Garage garage);
}

package peaksoft.dao;

import peaksoft.model.Company;

public interface CompanyDao {
    void createTables();
    void deleteById(Long id);
    void saveCompany(Company company);
}

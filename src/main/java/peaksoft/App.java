package peaksoft;

import org.hibernate.SessionFactory;
import peaksoft.dao.*;
import peaksoft.daoImpl.*;
import peaksoft.model.*;
import peaksoft.util.Util;

public class App 
{
    public static void main( String[] args ) {
        CompanyDao companyDao = new CompanyDaoImpl();
        Company company = new Company();
        companyDao.saveCompany(company);


        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person("Moont",17,"moont@gmail.com","male");
        personDao.savePerson(person);


        CarDao carDao = new CarDaoImpl();
        Car car = new Car("Taigan","Kyrgyzstan");
        carDao.saveCar(car);


        GarageDao garageDao= new GarageDaoImpl();
        Garage garage = new Garage("GDrive","free");
        garageDao.saveGarage(garage);

    }

}

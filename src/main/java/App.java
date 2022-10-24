import dao.CityDaoImpl;
import dao.CountryDaoImpl;
import dao.CountryLanguageDaoImpl;
import models.City;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //CITYDAO
        CityDaoImpl cityDao = new CityDaoImpl();

        //++Lista ciudades
        //System.out.println(cityDao.listaCiudades());

        //++Existe ciudad
        //System.out.println(cityDao.existeCiudad(12));

        //++Ver ciudad
        //System.out.println(cityDao.getCity(12));

        //++Ver pais de ciudad
        //System.out.println(cityDao.getPaisDeCiudad(12));

        //Ver si ciudad está en pais


        //Cambiar nombre de ciudad


        //++Añadir ciudad
        City city1 = new City(0,"Zaragoza", "ESP", "Aragon", 500000 );
        cityDao.aniadirCiudad(city1);


        //COUNTRYDAO
        CountryDaoImpl countryDaoImpl = new CountryDaoImpl();

        //Lista paises
        System.out.println(countryDaoImpl.listaPaises());

        //Existe pais


        //Ver pais


        //Lista ciudades del pais


        //Añadir pais



        //LANGUAGES
        CountryLanguageDaoImpl countryLanguageDaoImpl = new CountryLanguageDaoImpl();

        //Lista todos los idiomas


        //Lista de todos los idiomas de un pais

    }

}

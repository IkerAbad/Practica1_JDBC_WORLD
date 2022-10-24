package dao;

import models.City;
import models.Country;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CountryDaoImpl {
    Connection con = null;

    public Set<Country> listaPaises() {
        //Devuelve la lista complete de paises registrados en la base de datos.
        String query = "SELECT * FROM country";
        boolean check = false;
        Set<Country> countries = new HashSet<>();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                Country c = new Country();
                c.setCode(rs.getString("code"));
                c.setName(rs.getString("name"));
                c.setContinent(rs.getString("continent"));
                c.setRegion(rs.getString("region"));
                c.setSurfacearea(rs.getInt("surfacearea"));
                c.setIndepyear(rs.getInt("indepyear"));
                c.setPopulation(rs.getInt("population"));
                c.setLifeexpentancy(rs.getDouble("lifeexpentancy"));
                c.setGnp(rs.getDouble("gnp"));
                c.setGnpold(rs.getInt("gnpold"));
                c.setLocalname(rs.getString("localname"));
                c.setGovernmentform(rs.getString("governmentform"));
                c.setHeadofstate(rs.getString("headofstate"));
                c.setCapital(rs.getInt("capital"));
                c.setCode2(rs.getString("code2"));
                countries.add(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return countries;
        } else
            return null;
    }

    public Boolean existePais(String codigoPais){
        //Devuelve verdadero en caso de que el país esté registrado y falso en caso contrario.
        String query = "SELECT * FROM country WHERE id= ?";
        boolean check = false;
        Country country = new Country();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, codigoPais);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public Country getCountry(String codigoPais){
        //Devuelve un objeto de tipo Country con información del país con código codigoPais.
        String query = "SELECT * FROM city WHERE id= ?";
        boolean check = false;
        Country c = new Country();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, codigoPais);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                c.setCode(rs.getString("code"));
                c.setName(rs.getString("name"));
                c.setContinent(rs.getString("continent"));
                c.setRegion(rs.getString("region"));
                c.setSurfacearea(rs.getInt("surfacearea"));
                c.setIndepyear(rs.getInt("indepyear"));
                c.setPopulation(rs.getInt("population"));
                c.setLifeexpentancy(rs.getDouble("lifeexpentancy"));
                c.setGnp(rs.getDouble("gnp"));
                c.setGnpold(rs.getInt("gnpold"));
                c.setLocalname(rs.getString("localname"));
                c.setGovernmentform(rs.getString("governmentform"));
                c.setHeadofstate(rs.getString("headofstate"));
                c.setCapital(rs.getInt("capital"));
                c.setCode2(rs.getString("code2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return c;
        } else
            return null;
    }

    public Set<City> listaCiudades(String nombrePais){
        //Devuelve una lista complete de las ciudades que pertenecen al país cuyo nombre se pasa como parámetro.
        String query = "SELECT c.* FROM city c JOIN country co on c.ID = co.CODE=?";
        boolean check = false;
        City c = new City();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombrePais);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setCountrycode(rs.getString("countrycode"));
                c.setDistrict(rs.getString("district"));
                c.setPopulation(rs.getInt("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return (Set<City>) c;
        } else
            return null;

    }

    public Boolean aniadirPais(Country nuevoPais){
        //Añadir un nuevo país a la base de datos.
        //Comprobar si el país existe antes de realizar la inserción mediante existePais.
        String query = "INSERT INTO country ( code, name, continent, region, surfacearea, indepyear, population, lifeexpentancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int res = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nuevoPais.getCode());
            ps.setString(2, nuevoPais.getName());
            ps.setString(3, nuevoPais.getContinent());
            ps.setString(4, nuevoPais.getRegion());
            ps.setInt(5, nuevoPais.getSurfacearea());
            ps.setInt(6, nuevoPais.getIndepyear());
            ps.setInt(7, nuevoPais.getPopulation());
            ps.setDouble(8, nuevoPais.getLifeexpentancy());
            ps.setDouble(9, nuevoPais.getGnp());
            ps.setInt(10, nuevoPais.getGnpold());
            ps.setString(11, nuevoPais.getLocalname());
            ps.setString(12, nuevoPais.getGovernmentform());
            ps.setString(13, nuevoPais.getHeadofstate());
            ps.setInt(14, nuevoPais.getCapital());
            ps.setString(15, nuevoPais.getCode2());

            res = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();}

        return aniadirPais(nuevoPais);
    }
    public boolean ifExitsCountry(int id) {
        String query = "SELECT * FROM country WHERE id= ?";
        boolean check = false;
        Country country = new Country();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

}

package dao;

import models.City;
import models.Country;
import models.Countrylanguage;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountryLanguageDaoImpl {
    Connection con = null;

    public List<Countrylanguage> getAllLanguages(){
        //Devuelve una lista con todos los lenguajes registrados en la base de datos.
        String query = "SELECT * FROM countrylanguage";
        boolean check = false;
        List<Countrylanguage> languages = new ArrayList<Countrylanguage>();

        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                check = true;
                Countrylanguage c = new Countrylanguage();
                c.setCountrycode(rs.getString("countrycode"));
                c.setLanguage(rs.getString("language"));
                c.setIsofficial(rs.getString("isofficial"));
                c.setPercentage(rs.getDouble("percentage"));

                languages.add(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check == true) {
            return languages;
        } else
            return null;
    }

    public Set<Countrylanguage> listaIdiomas(String codigoPais){
        //Devuelve una lista con todos los idiomas del país con código codigoPais.


        return listaIdiomas(codigoPais);
    }


}

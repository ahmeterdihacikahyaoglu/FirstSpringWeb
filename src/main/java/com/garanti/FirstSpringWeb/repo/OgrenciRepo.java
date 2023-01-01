package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ogrenci;

import java.sql.*;
import java.util.ArrayList;

public class OgrenciRepo {
    public ArrayList<Ogrenci> getAll()
    {
        ArrayList<Ogrenci> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.OGRENCI");
            while (result.next())
            {
                Ogrenci temp = new Ogrenci(result.getInt("ID"), result.getString("NAME"), result.getInt("OGR_NUMBER"),result.getInt("YEAR"));
                liste.add(temp);
            }
        }
        catch (Exception e)
        {
            liste.clear();
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                result.close();
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                // throw new mybussinessexception()
            }
        }
        return liste;
    }

    public Ogrenci getById(int id)
    {
        Ogrenci ogrenci = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("select * from BILGE.OGRENCI where ID = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next())
            {
                ogrenci = new Ogrenci(result.getInt("ID"), result.getString("NAME"), result.getInt("OGR_NUMBER"),result.getInt("YEAR"));
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                result.close();
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                // throw new mybussinessexception()
            }
        }
        return ogrenci;
    }

    public boolean deleteById( int id){
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("delete from BILGE.OGRENCI where ID = ?");
            stmt.setInt(1,id);
            result = stmt.executeUpdate() == 1;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {

            }
        }
        return result;
    }

    public boolean save ( Ogrenci ogrenci)
    {
        boolean result = false ;
        Connection connection = null;
        PreparedStatement stmt = null;

        try
        {
            connection= Constants.getConnection();
            stmt = connection.prepareStatement("Insert into BILGE.OGRENCI (NAME,OGR_NUMBER,YEAR) values (?,?,?)");
            stmt.setString(1, ogrenci.getNAME());
            stmt.setInt(2, ogrenci.getOGR_NUMBER());
            stmt.setInt(3, ogrenci.getYEAR());
            result = stmt.executeUpdate() == 1;
        }
        catch (SQLException e)
        {
            System.err.println("-> " +e.getClass().getName());
            System.err.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println("-> " +e.getClass().getName());
        }
        finally
        {
            try
            {
                stmt.close();;
                connection.close();
            }
            catch (Exception e)
            {

            }
        }
        return result;
    }


}

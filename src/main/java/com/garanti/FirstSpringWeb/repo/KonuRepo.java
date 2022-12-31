package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Konu;

import java.sql.*;
import java.util.ArrayList;

public class KonuRepo {
    public  ArrayList<Konu> getAll()
    {
        ArrayList<Konu> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.KONU");
            while (result.next())
            {
                Konu temp = new Konu(result.getInt("ID"), result.getString("NAME"));
                liste.add(temp);
            }
        }
        catch (Exception e)
        {
            liste.clear();
        }
        finally
        {
            try {
                result.close();
                stmt.close();
                connection.close();
            }
            catch (SQLException ex)
            {
                // throw new mybussinessexception()
            }

        }
        return liste;
    }

    public Konu getById(int id)
    {
        Konu konu = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try
        {
            connection =Constants.getConnection();
            stmt = connection.prepareStatement("select * from BILGE.KONU where ID = ?");
            stmt.setInt(1,id);
            result = stmt.executeQuery();
            while (result.next())
            {
                konu = new Konu(result.getInt("ID"), result.getString("NAME"));
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
        return konu;
    }

    public boolean deleteById(int id)
    {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("delete from BILGE.KONU where ID = ?");
            stmt.setInt(1, id);
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

    public boolean save(Konu konu)
    {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("Insert into BILGE.KONU (NAME) values (?)");
            stmt.setString(1, konu.getNAME());
            result = stmt.executeUpdate() == 1;
        }
        catch (SQLException e)
        {
            System.err.println("-> " + e.getClass().getName());
            System.err.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println("-> " + e.getClass().getName());
        }
        finally
        {
            try
            {
                stmt.close();
                connection.close();
            }
            catch (Exception e)
            {
            }
        }
        return result;
    }

}

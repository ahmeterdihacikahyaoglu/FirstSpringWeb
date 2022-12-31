package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ogretmen;
import com.garanti.FirstSpringWeb.model.Ders;
import com.garanti.FirstSpringWeb.model.Konu;

import java.sql.*;
import java.util.ArrayList;

public class DersRepo
{
    public boolean save(Ogretmen ogretmen, Konu konu)
    {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        try
        {
            connection = Constants.getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("Insert into BILGE.OGRETMEN (NAME, IS_GICIK) values (?, ?)");
            stmt.setString(1, ogretmen.getNAME());
            stmt.setBoolean(2, ogretmen.isIS_GICIK());
            stmt.executeUpdate();
            stmt.close();
            // ------------------
            stmt = connection.prepareStatement("Insert into BILGE.KON (NAME) values (?)");
            stmt.setString(1, konu.getNAME());
            stmt.executeUpdate();
            stmt.close();
            // -----------------
            stmt = connection.prepareStatement("INSERT INTO ders (ogr_id, konu_id) VALUES (?, ?)");
            // nasıl olsa foreign key 'den patlayacak
            stmt.setInt(1, 11);
            stmt.setInt(2, 5);
            result = stmt.executeUpdate() == 1;
            connection.commit();
        }
        catch (Exception e)
        {
            result = false;
            try
            {
                connection.rollback();
            }
            catch (SQLException ex)
            {
            }
            System.err.println(e.getMessage());
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

    public ArrayList<Ders> getAll()
    {
        ArrayList<Ders> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.DERS");
            while (result.next())
            {
                Ders temp = new Ders(result.getInt("ID"), result.getInt("OGR_ID"), result.getInt("KONU_ID"));
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

    public Ders getById(int id)
    {
        Ders ders = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("select * from BILGE.DERS where ID = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next())
            {
                ders = new Ders(result.getInt("ID"), result.getInt("OGR_ID"), result.getInt("KONU_ID"));
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
        return ders;
    }

    public boolean deleteById(int id)
    {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("delete from BILGE.DERS where ID = ?");
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

    public boolean save(Ders ders)
    {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("Insert into BILGE.DERS (OGR_ID,KONU_ID) values (?,?)");
            stmt.setInt(1, ders.getOGR_ID());
            stmt.setInt(2, ders.getKONU_ID());
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

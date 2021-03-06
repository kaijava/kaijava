/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataHelp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHI LONG
 */
public class EmployeeController {
    DataHelp db = new DataHelp();
    //get all employee
    public List<Employees> getEmployee() throws SQLException{
        List<Employees> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Employee_GetAll}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            rs = call.executeQuery();
            while(rs.next()){
                Employees e = new Employees(rs.getInt("EmployeeID"),rs.getString("Lastname"),rs.getString("FirstName"),rs.getDate("BirthDay"),rs.getDate("HireDay"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("Zipcode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Email"),rs.getString("Photo"),rs.getString("PhotoPath"),rs.getInt("ReportTo"),rs.getString("TypeAccount"),rs.getBoolean("StatusAccount"));
                list.add(e);
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
            rs.close();
        }
        return list;
    }
    //get Employee by ID
    public List<Employees> getSupplierByID(int id) throws SQLException{
        List<Employees> list = new ArrayList<>();
        CallableStatement call = null;
        ResultSet rs = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Employee_GetID(?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            call.setInt("EmployeeID", id);
            rs = call.executeQuery();
            while(rs.next()){
                Employees e = new Employees(rs.getInt("EmployeeID"),rs.getString("Lastname"),rs.getString("FirstName"),rs.getDate("BirthDay"),rs.getDate("HireDay"),rs.getString("Address"),rs.getString("City"),rs.getString("Region"),rs.getString("Zipcode"),rs.getString("Country"),rs.getString("Phone"),rs.getString("Email"),rs.getString("Photo"),rs.getString("PhotoPath"),rs.getInt("ReportTo"),rs.getString("TypeAccount"),rs.getBoolean("StatusAccount"));
                list.add(e);
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
            rs.close();
        }
        return list;
    }
    //insert Employee
    public int insertEmployee(Employees e) throws SQLException{
        int row = 0;
        CallableStatement call = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Employee_Insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            call.setString("Lastname", e.getLastname());
            call.setString("FirstName", e.getFirstName());
            call.setDate("BirthDay", e.getBirthDay());
            call.setDate("HireDay", e.getHireDay());
            call.setString("Address", e.getAddress());
            call.setString("City", e.getCity());
            call.setString("Region", e.getRegion());
            call.setString("Zipcode", e.getZipcode());
            call.setString("Country", e.getCountry());
            call.setString("Phone", e.getPhone());
            call.setString("Email", e.getEmail());
            call.setString("Photo", e.getPhoto());
            call.setString("PhotoPath", e.getPhotoPath());
            call.setInt("PeportTo", e.getReportTo());
            call.setString("TypeAccount", e.getTypeAccount());
            call.setBoolean("StatusAccount", e.isStatusAccount());
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
        }
        return row;
    }
    //update Employee
    public int updateEmployee(Employees e) throws SQLException{
        int row = 0;
        CallableStatement call = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Employee_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
	    call.setInt("EmployeeID", e.getEmployeeID());
            call.setString("Lastname", e.getLastname());
            call.setString("FirstName", e.getFirstName());
            call.setDate("BirthDay", e.getBirthDay());
            call.setDate("HireDay", e.getHireDay());
            call.setString("Address", e.getAddress());
            call.setString("City", e.getCity());
            call.setString("Region", e.getRegion());
            call.setString("Zipcode", e.getZipcode());
            call.setString("Country", e.getCountry());
            call.setString("Phone", e.getPhone());
            call.setString("Email", e.getEmail());
            call.setString("Photo", e.getPhoto());
            call.setString("PhotoPath", e.getPhotoPath());
            call.setInt("PeportTo", e.getReportTo());
            call.setString("TypeAccount", e.getTypeAccount());
            call.setBoolean("StatusAccount", e.isStatusAccount());
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
        }
        return row;
    }
    //delete Employee
    public int deleteEmployee(int id) throws SQLException{
        int row = 0;
        CallableStatement call = null;
        Connection cn = null;
        try{
            String strSql = "{call sp_Employee_Delete(?)}";
            cn = db.getCon();
            call = cn.prepareCall(strSql);
            call.setInt("EmployeeID", id);
            row = call.executeUpdate();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            cn.close();
            call.close();
        }
        return row;
    }
}

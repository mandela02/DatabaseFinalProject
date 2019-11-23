/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import GUILayer.Login;
import POJO.Class;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author --Client-ServEr--
 */
public class Class_DataLayer {
    
    
        //Phuong thuc search student cho vao ArrayList
       //Phuong thuc search student cho vao ArrayList
    public static ArrayList<Class> SearchAllClass(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String ClassName)
    {
        Connection Connection;
    ArrayList<Class> ArrayList=new ArrayList<Class>();
    PostGreSQL SQL=new PostGreSQL();
        try {
              Connection=SQL.open(HostAddress,Port,DatabaseName,UserName,PassWord);
              CallableStatement st=Connection.prepareCall("{call get_all_class(?)}");
              st.setString(1,ClassName);
              ResultSet RS=st.executeQuery();
              while(RS.next())
              {
                  Class cla=new Class();
               cla.SetClassID(RS.getString(1));
               cla.SetClassName(RS.getString(2));
               cla.SetYear(RS.getInt(3));
               cla.SetMoniterID(RS.getString(4));
               cla.SetDepartmentID(RS.getString(5));
                  ArrayList.add(cla);
              }
              SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(Class_DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
    
       public static ArrayList<Class>SearchCLassID(String ClassID,Login login)
    {
        ArrayList<Class> ArrayList=new ArrayList<Class>();
        Connection connection;
        PostGreSQL SQL=new PostGreSQL();
        try {
            connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
            CallableStatement st=connection.prepareCall("{call search_classid(?)}");
           st.setString(1,ClassID);
           ResultSet RS=st.executeQuery();
           while(RS.next())
           {
               Class cla=new Class();
               cla.SetClassID(RS.getString(1));
               cla.SetClassName(RS.getString(2));
               cla.SetYear(RS.getInt(3));
               cla.SetMoniterID(RS.getString(4));
               cla.SetDepartmentID(RS.getString(5));
               ArrayList.add(cla);
           }
          SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
           public static ArrayList<Class> SearchAllClassForChart(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord)
    {
        Connection Connection;
    ArrayList<Class> ArrayList=new ArrayList<Class>();
    PostGreSQL SQL=new PostGreSQL();
        try {
              Connection=SQL.open(HostAddress,Port,DatabaseName,UserName,PassWord);
              CallableStatement st=Connection.prepareCall("{call get_all_class_for_chart()}");
              ResultSet RS=st.executeQuery();
              while(RS.next())
              {
                  Class cla=new Class();
               cla.SetClassID(RS.getString(1));
               cla.SetClassName(RS.getString(2));
               cla.SetYear(RS.getInt(3));
               cla.SetMoniterID(RS.getString(4));
               cla.SetDepartmentID(RS.getString(5));
                  ArrayList.add(cla);
              }
              SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(Class_DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
}

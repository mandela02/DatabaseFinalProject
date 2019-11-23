/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import GUILayer.Login;
import POJO.Participation;
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
public class Participation_DataLayer {
    
     public static ArrayList<POJO.Participation>SearchOrganizationID(String StudentID,String OrganizationID,Login login)
    {
        ArrayList<POJO.Participation> ArrayList=new ArrayList<POJO.Participation>();
        Connection connection;
        PostGreSQL SQL=new PostGreSQL();
        try {
            connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
            CallableStatement st=connection.prepareCall("{call search_participation(?,?)}");
           st.setString(1,StudentID);
           st.setString(2,OrganizationID);
           ResultSet RS=st.executeQuery();
           while(RS.next())
           {
             Participation par=new Participation();
             par.SetStudentID(RS.getString(1));
             par.SetOrganization(RS.getString(2));
             par.SetRole(RS.getString(3));
             par.SetTimeStart(RS.getDate(4));
             par.SetTimeEnd(RS.getDate(5));
          ArrayList.add(par);
           }
          SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
     
     
     
         
     public static ArrayList<POJO.Participation>SearchParticipationDelete(String StudentID,String OrgID,Login login)
    {
        ArrayList<POJO.Participation> ArrayList=new ArrayList<POJO.Participation>();
        Connection connection;
        PostGreSQL SQL=new PostGreSQL();
        try {
            connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
            CallableStatement st=connection.prepareCall("{call search_participation_delete(?,?)}");
            st.setString(1,StudentID);
            st.setString(2, OrgID);
           ResultSet RS=st.executeQuery();
           while(RS.next())
           {
             Participation par=new Participation();
             par.SetStudentID(RS.getString(1));
             par.SetOrganization(RS.getString(2));
             par.SetRole(RS.getString(3));
             par.SetTimeStart(RS.getDate(4));
             par.SetTimeEnd(RS.getDate(5));
          ArrayList.add(par);
           }
          SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
}

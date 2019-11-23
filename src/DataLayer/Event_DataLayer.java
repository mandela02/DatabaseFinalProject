/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import GUILayer.Login;
import POJO.Event;
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
public class Event_DataLayer {
    
    
        public static ArrayList<Event> SearchAllEvent(Login login,String EventName)
    {
        Connection Connection;
        ArrayList<Event> ArrayList=new ArrayList<Event>();
        PostGreSQL SQL=new PostGreSQL();
        try {
              Connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
              CallableStatement st=Connection.prepareCall("{call get_all_event(?)}");
              st.setString(1,EventName);
              ResultSet RS=st.executeQuery();
              while(RS.next())
              {
               Event event=new Event();
               event.SetEventID(RS.getString(1));
               event.SetEventName(RS.getString(2));
               event.SetLocation(RS.getString(3));
               event.SetTimeStart(RS.getDate(4));
               event.SetTimeEnd(RS.getDate(5));
               event.SetNumOfPeople(RS.getInt(6));
               event.SetRating(RS.getInt(7));
                  ArrayList.add(event);
              }
              SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student_DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
            
        public static ArrayList<Event> SearchAllEventForChart(Login login)
    {
        Connection Connection;
        ArrayList<Event> ArrayList=new ArrayList<Event>();
        PostGreSQL SQL=new PostGreSQL();
        try {
              Connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
              CallableStatement st=Connection.prepareCall("{call get_all_event_for_chart()}");
            ResultSet RS=st.executeQuery();
              while(RS.next())
              {
               Event event=new Event();
               event.SetEventID(RS.getString(1));
               event.SetEventName(RS.getString(2));
               event.SetLocation(RS.getString(3));
               event.SetTimeStart(RS.getDate(4));
               event.SetTimeEnd(RS.getDate(5));
               event.SetNumOfPeople(RS.getInt(6));
               event.SetRating(RS.getInt(7));
                  ArrayList.add(event);
              }
              SQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student_DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayList;
    }
}

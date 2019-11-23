/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import static DataLayer.Class_DataLayer.SearchAllClass;
import static DataLayer.Event_DataLayer.SearchAllEvent;
import static DataLayer.Organization_DataLayer.SearchAllOrganization;
import static DataLayer.Student_DataLayer.SearchAllStudent;
import GUILayer.Login;
import POJO.Class;
import POJO.Event;
import POJO.Organization;
import POJO.Student;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author --Client-ServEr--
 */
public class ShowManager {
    
    //Phuong thuc search student with Last Name
     public DefaultTableModel SearchStudentTextField(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String Name)
    {
        int n,i;
    ArrayList<Student> ArrayList=new ArrayList<Student>();
    ArrayList=SearchAllStudent(HostAddress,Port,DatabaseName,UserName,PassWord,Name);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Student ID");
    DTM.addColumn("First Name");
    DTM.addColumn("Last Name");
    DTM.addColumn("BirthDay");
    DTM.addColumn("Mobile");
    n=ArrayList.size();
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetStudentID());
        vt.add(ArrayList.get(i).GetFirstName());
        vt.add(ArrayList.get(i).GetLastName());
        vt.add(ArrayList.get(i).GetBirthDay());
        vt.add(ArrayList.get(i).GetMobile());
        DTM.addRow(vt);
    }
    return DTM;
    }  
     
    //Phuong thuc search student with TextField and Button
     public DefaultTableModel SearchStudentButton(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String Name)
    {
        int n,i;
    ArrayList<Student> ArrayList=new ArrayList<Student>();
    ArrayList=SearchAllStudent(HostAddress,Port,DatabaseName,UserName,PassWord,Name);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Student ID");
    DTM.addColumn("First Name");
    DTM.addColumn("Last Name");
    DTM.addColumn("BirthDay");
    DTM.addColumn("Mobile");
    n=ArrayList.size();
    if(n==0)
        JOptionPane.showMessageDialog(null,"Cannot find any Student!");
    else
    {
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetStudentID());
        vt.add(ArrayList.get(i).GetFirstName());
        vt.add(ArrayList.get(i).GetLastName());
        vt.add(ArrayList.get(i).GetBirthDay());
        vt.add(ArrayList.get(i).GetMobile());
        DTM.addRow(vt);
    }
    }
    return DTM;
    } 
     
     //Phuong thuc search class with name textfield
          public DefaultTableModel SearchClassTextField(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String ClassName)
    {
        int n,i;
    ArrayList<Class> ArrayList=new ArrayList<Class>();
    ArrayList=SearchAllClass(HostAddress,Port,DatabaseName,UserName,PassWord,ClassName);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Class ID");
    DTM.addColumn("Class Name");
    DTM.addColumn("Year");
    DTM.addColumn("Monitor ID");
    DTM.addColumn("Department ID");
    n=ArrayList.size();
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetClassID());
        vt.add(ArrayList.get(i).GetClassName());
        vt.add(ArrayList.get(i).GetYear());
        vt.add(ArrayList.get(i).GetMoniterID());
        vt.add(ArrayList.get(i).GetDepartmentID());
        DTM.addRow(vt);
    }
    return DTM;
    } 
          
    //Phuong thuc search Clas with textfield and button
  public DefaultTableModel SearchClassButton(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String ClassName)
    {
        int n,i;
    ArrayList<Class> ArrayList=new ArrayList<Class>();
    ArrayList=SearchAllClass(HostAddress,Port,DatabaseName,UserName,PassWord,ClassName);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Class ID");
    DTM.addColumn("Class Name");
    DTM.addColumn("Year");
    DTM.addColumn("Monitor ID");
    DTM.addColumn("Department ID");
    n=ArrayList.size();
    if(n==0)
        JOptionPane.showMessageDialog(null,"Canot find any Class!");
    else
    {
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetClassID());
        vt.add(ArrayList.get(i).GetClassName());
        vt.add(ArrayList.get(i).GetYear());
        vt.add(ArrayList.get(i).GetMoniterID());
        vt.add(ArrayList.get(i).GetDepartmentID());
        DTM.addRow(vt);
    }
    }
    return DTM;
    } 
  
     //Phuong thuc search Organization textfield
  public DefaultTableModel SearchOrganizationTextField(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String OrgName)
    {
        int n,i;
    ArrayList<Organization> ArrayList=new ArrayList<Organization>();
    ArrayList=SearchAllOrganization(HostAddress,Port,DatabaseName,UserName,PassWord,OrgName);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Organization ID");
    DTM.addColumn("Organization Name");
    DTM.addColumn("Manager");
    DTM.addColumn("Email");
    DTM.addColumn("Mobile");
    n=ArrayList.size();
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetOrganizationID());
        vt.add(ArrayList.get(i).GetOrganizationName());
        vt.add(ArrayList.get(i).GetManager());
        vt.add(ArrayList.get(i).GetEmail());
        vt.add(ArrayList.get(i).GetMobile());
        DTM.addRow(vt);
    }
    return DTM;
    } 
  
  
    //Phuong thuc search Organization textfield and Button
  public DefaultTableModel SearchOrganizationButton(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String OrgName)
    {
        int n,i;
    ArrayList<Organization> ArrayList=new ArrayList<Organization>();
    ArrayList=SearchAllOrganization(HostAddress,Port,DatabaseName,UserName,PassWord,OrgName);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Organization ID");
    DTM.addColumn("Organization Name");
    DTM.addColumn("Manager");
    DTM.addColumn("Email");
    DTM.addColumn("Mobile");
    n=ArrayList.size();
    if(n==0)
        JOptionPane.showMessageDialog(null,"Cannot find any Organization!");
    else
    {
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetOrganizationID());
        vt.add(ArrayList.get(i).GetOrganizationName());
        vt.add(ArrayList.get(i).GetManager());
        vt.add(ArrayList.get(i).GetEmail());
        vt.add(ArrayList.get(i).GetMobile());
        DTM.addRow(vt);
    }
    }
    return DTM;
    } 
  
       public DefaultTableModel SearchEventTextField(Login login,String EventName)
    {
        int n,i;
    ArrayList<Event> ArrayList=new ArrayList<Event>();
    ArrayList=SearchAllEvent(login,EventName);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Event ID");
    DTM.addColumn("Event Name");
    DTM.addColumn("Location");
    DTM.addColumn("TimeStart");
    DTM.addColumn("TimeEnd");
    DTM.addColumn("Num Of People");
    n=ArrayList.size();
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetEventID());
        vt.add(ArrayList.get(i).GetEventName());
        vt.add(ArrayList.get(i).GetLocation());
        vt.add(ArrayList.get(i).GetTimeStart());
        vt.add(ArrayList.get(i).GetTimeEnd());
        vt.add(ArrayList.get(i).GetNumOfPeople());
        DTM.addRow(vt);
    }
    return DTM;
    }  
     
    //Phuong thuc search student with TextField and Button
     public DefaultTableModel SearchEventButton(Login login,String EventName)
    {
        int n,i;
    ArrayList<Event> ArrayList=new ArrayList<Event>();
    ArrayList=SearchAllEvent(login,EventName);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Event ID");
    DTM.addColumn("Event Name");
    DTM.addColumn("Location");
    DTM.addColumn("TimeStart");
    DTM.addColumn("TimeEnd");
    DTM.addColumn("Num Of People");
    n=ArrayList.size();
    if(n==0)
        JOptionPane.showMessageDialog(null,"Cannot find any Event!");
    else
    {
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetEventID());
        vt.add(ArrayList.get(i).GetEventName());
        vt.add(ArrayList.get(i).GetLocation());
        vt.add(ArrayList.get(i).GetTimeStart());
        vt.add(ArrayList.get(i).GetTimeEnd());
        vt.add(ArrayList.get(i).GetNumOfPeople());
        DTM.addRow(vt);
    }
    }
    return DTM;
    } 
     
          public DefaultTableModel SearchStudentTextFieldForEdit(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String Name)
    {
        int n,i;
    ArrayList<Student> ArrayList=new ArrayList<Student>();
    ArrayList=SearchAllStudent(HostAddress,Port,DatabaseName,UserName,PassWord,Name);
    DefaultTableModel DTM=new DefaultTableModel();
    DTM.addColumn("Student ID");
    DTM.addColumn("First Name");
    DTM.addColumn("Last Name");
    DTM.addColumn("Gender");
    DTM.addColumn("BirthDay");
    DTM.addColumn("Mobile");
    DTM.addColumn("Email");
    DTM.addColumn("Adress");
    DTM.addColumn("ClassID");
    DTM.addColumn("Description");
    DTM.addColumn("Status");
    
    n=ArrayList.size();
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
        vt.add(ArrayList.get(i).GetStudentID());
        vt.add(ArrayList.get(i).GetFirstName());
        vt.add(ArrayList.get(i).GetLastName());
        vt.add(ArrayList.get(i).GetaGender());
        vt.add(ArrayList.get(i).GetBirthDay());
        vt.add(ArrayList.get(i).GetMobile());
        vt.add(ArrayList.get(i).GetEmail());
        vt.add(ArrayList.get(i).GetAddress());
        vt.add(ArrayList.get(i).GetClassID());
        vt.add(ArrayList.get(i).GetDescription());
        vt.add(ArrayList.get(i).GetStatus());
        DTM.addRow(vt);
    }
    return DTM;
    }  
          
          
               public DefaultTableModel SearchStudentButtonForEdit(String HostAddress,String Port,String DatabaseName,String UserName,String PassWord,String Name)
    {
        int n,i;
    ArrayList<Student> ArrayList=new ArrayList<Student>();
    ArrayList=SearchAllStudent(HostAddress,Port,DatabaseName,UserName,PassWord,Name);
    DefaultTableModel DTM=new DefaultTableModel();
      DTM.addColumn("Student ID");
    DTM.addColumn("First Name");
    DTM.addColumn("Last Name");
    DTM.addColumn("Gender");
    DTM.addColumn("BirthDay");
    DTM.addColumn("Mobile");
    DTM.addColumn("Email");
    DTM.addColumn("Adress");
    DTM.addColumn("ClassID");
    DTM.addColumn("Description");
    DTM.addColumn("Status");
    n=ArrayList.size();
    if(n==0)
        JOptionPane.showMessageDialog(null,"Cannot find any Student!");
    else
    {
    for(i=0;i<n;i++)
    {
        Vector vt=new Vector();
          vt.add(ArrayList.get(i).GetStudentID());
        vt.add(ArrayList.get(i).GetFirstName());
        vt.add(ArrayList.get(i).GetLastName());
        vt.add(ArrayList.get(i).GetaGender());
        vt.add(ArrayList.get(i).GetBirthDay());
        vt.add(ArrayList.get(i).GetMobile());
        vt.add(ArrayList.get(i).GetEmail());
        vt.add(ArrayList.get(i).GetAddress());
        vt.add(ArrayList.get(i).GetClassID());
        vt.add(ArrayList.get(i).GetDescription());
        vt.add(ArrayList.get(i).GetStatus());
        DTM.addRow(vt);
    }
    }
    return DTM;
    }
}

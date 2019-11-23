/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import GUILayer.Login;
import POJO.Class;
import POJO.Department;
import POJO.Organization;
import POJO.Student;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author --Client-ServEr--
 */
public class AddManager {
    public void  AddStudentManager(Student student,Login login)
    {
        
        Connection connection;
        PostGreSQL SQL=new PostGreSQL();
        try {
            connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
            CallableStatement st=connection.prepareCall("{call insert_into_student(?,?,?,?,?,?,?,?,?,?,?)}");
           st.setString(1,student.GetStudentID());
           st.setString(2,student.GetFirstName());
           st.setString(3,student.GetLastName());
           st.setBoolean(4,student.GetaGender());
           st.setDate(5, (Date) student.GetBirthDay());
           st.setString(6,student.GetMobile());
           st.setString(7,student.GetEmail());
           st.setString(8,student.GetAddress());
           st.setString(9,student.GetClassID());
           st.setString(10,student.GetDescription());
           st.setInt(11,student.GetStatus());
            int n=st.executeUpdate();
            if(n>=0)
            {
                JOptionPane.showMessageDialog(null,"Insert Success!");
            }
            else
                JOptionPane.showMessageDialog(null,"Insert Falsed!");
        } catch (SQLException ex) {
            Logger.getLogger(AddManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int CheckClassID(String ClassID,Login login)
    {
        ArrayList<Class> ArrayList=new ArrayList<Class>();
        ArrayList=DataLayer.Class_DataLayer.SearchCLassID(ClassID, login);
      if(ArrayList.size()==0)
        return 0;
        else
         return 1;
    }
    
    public int CheckStudentID(String StudentID,Login login)
    {
        ArrayList<Student> ArrayList=new ArrayList<Student>();
        ArrayList=DataLayer.Student_DataLayer.SearchStudentID(StudentID, login);
      if(ArrayList.size()==0)
        return 0;
        else
         return 1;
    }
    public void  AddClassManager(Class cla,Login login)
    {
        
        Connection connection;
        PostGreSQL SQL=new PostGreSQL();
        try {
            connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
            CallableStatement st=connection.prepareCall("{call insert_into_class(?,?,?,?,?)}");
            st.setString(1,cla.GetClassID());
            st.setString(2,cla.GetClassName());
            st.setInt(3,cla.GetYear());
            st.setString(4,cla.GetMoniterID());
            st.setString(5,cla.GetDepartmentID());
            int n=st.executeUpdate();
            if(n>=0)
            {
                JOptionPane.showMessageDialog(null,"Insert Success!");
            }
            else
                JOptionPane.showMessageDialog(null,"Insert Falsed!");
        } catch (SQLException ex) {
            Logger.getLogger(AddManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public int CheckDepartmentID(String DepartmentID,Login login)
    {
        ArrayList<Department> ArrayList=new ArrayList<Department>();
        ArrayList=DataLayer.Department_DateLayer.SearchDepartmentID(DepartmentID, login);
      if(ArrayList.size()==0)
        return 0;
        else
         return 1;
    }
        
        
    public int CheckOrganizationID(String OrgID,Login login)
    {
        ArrayList<Organization> ArrayList=new ArrayList<Organization>();
        ArrayList=DataLayer.Organization_DataLayer.SearchOrganizationID(OrgID, login);
      if(ArrayList.size()==0)
        return 0;
        else
         return 1;
    }
              
     public void  AddOrganizationManager(Organization org,Login login)
    {
        
        Connection connection;
        PostGreSQL SQL=new PostGreSQL();
        try {
            connection=SQL.open(login.GetHostAddress(),login.GetPort(),login.GetDatabaseName(),login.GetUserName(),login.GetPassWord());
            CallableStatement st=connection.prepareCall("{call insert_into_organization(?,?,?,?,?)}");
              st.setString(1,org.GetOrganizationID());
              st.setString(2,org.GetOrganizationName());
              st.setString(3,org.GetManager());
              st.setString(4,org.GetEmail());
              st.setString(5,org.GetMobile());
            int n=st.executeUpdate();
            if(n>=0)
            {
                JOptionPane.showMessageDialog(null,"Insert Success!");
            }
            else
                JOptionPane.showMessageDialog(null,"Insert Falsed!");
        } catch (SQLException ex) {
            Logger.getLogger(AddManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
              
              
              
}

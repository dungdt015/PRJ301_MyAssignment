/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Course;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;
import model.Subject;
/**
 *
 * @author admin
 */
public class CourseDBContext extends DBContext<Course>{
    public ArrayList<Course> filterByLecturerID(int lid) {
        ArrayList<Course> courses = new ArrayList<>();
        PreparedStatement stm = null;
        
        try{
            String sql= "SELECT c.cid,c.cname,c.subid,sub.subname,c.lid,s.semid,s.season,s.active,s.year FROM \n"
                    + "courses c INNER JOIN semester s ON s.semid = c.semid\n"
                    + "INNER JOIN subjects sub ON sub.subid = c.subid\n"
                    + "WHERE s.active = 1 AND c.lid = ?";
            stm= connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                
                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lid"));
                l.setCourses(courses);
                
                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                sub.setCourses(courses);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return courses;
    }
    @Override
    public ArrayList<Course> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Course get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Course model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

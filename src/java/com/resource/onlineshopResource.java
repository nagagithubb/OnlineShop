package com.resource;

import com.service.Inventory;
import com.service.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/shop")
public class onlineshopResource {

    @GET
    @Produces("application/json")
    @Path("verifyUser")
    public Response verifyUser(@QueryParam("userid") String userid, @QueryParam("password") String password) throws SQLException {
        ArrayList list = new ArrayList();
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","12345");
            String sql = "Select * from logintable Where UserId = ? And Password = ?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, userid);
                ps.setString(2, password);
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next())
                {   
                    System.out.println("--100--");
                    user.setPassword(rs.getString("Password"));
                    user.setUserId(rs.getString("UserId"));
                    list.add(user);
                    //return "UserId and Password is - " + rs.getString("UserId") + " And " + rs.getString("Password");
                    GenericEntity<User> entity = new GenericEntity<User>(user){};
                    return Response.status(200).entity(entity).build();
                }               
                conn.close();
                return Response.status(400).build();
            } catch (SQLException ex) {
                Logger.getLogger(onlineshopResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            return Response.status(400).build();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(onlineshopResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return Response.status(200).entity(list).build();
        //GenericEntity<User> entity = new GenericEntity<User>(user){};
        return Response.status(400).build();
    }

    @GET
    @Produces("application/json")
    @Path("searchInventory")
    public Response searchInventory(@QueryParam("searchtxt") String searchtxt) throws SQLException {
 
        ArrayList invList = new ArrayList();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","12345");
            String sql = "Select * from inventory Where functions like ?";
            
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + searchtxt + "%");            
                
                ResultSet rs = ps.executeQuery();
                Inventory inv;
                //int i=0;
                while(rs.next())
                {
                    inv = new Inventory(rs.getInt("id"),rs.getString("brand"),rs.getString("model"),rs.getString("functions"),rs.getString("quantity"));                    
                    invList.add(inv);                                        
                }
                conn.close();  
                return Response.status(200).entity(invList).build();
            } catch (SQLException ex) {
                Logger.getLogger(onlineshopResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            return Response.status(400).build();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(onlineshopResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return Response.status(400).build();
        return Response.status(400).build();
    }

}

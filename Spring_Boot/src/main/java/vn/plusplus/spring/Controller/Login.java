package vn.plusplus.spring.Controller;

import org.springframework.web.bind.annotation.*;
import vn.plusplus.spring.Connection.Connector;
import vn.plusplus.spring.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping(value = "/honme")
public class Login {
    @PostMapping(value = "/login")
    public String login(@RequestBody User user) throws SQLException {
        Connector connector = Connector.getInstance();
        Connection connection = connector.getConnection();
        String sql = "select * from User";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            if (user.getEmail().equals(rs.getString("Email")) == true) {
                if (user.getPassword().equals(rs.getString("Password")) == true) {
                    return "Login Successed";
                } else return "email or password faild";
            } else {
                return "Email does not exit";
            }
        }
        return "Login faild";
    }

    @PostMapping(value ="/register")
    public String register(@RequestBody User register) throws SQLException {
        Connector connector=Connector.getInstance();
        Connection connection=connector.getConnection();
        String sql="select Email from User ";
        Statement statement= connection.createStatement();
        ResultSet rs= statement.executeQuery(sql);
        if(register.checkEmail(register.getEmail())==false){
            return "Invaild Email";
        }
        while (rs.next()){
            if(register.getEmail().equals(rs.getString("Email"))==true){
                return "Email already exits";
            }else {
                if (register.checkPassword(register.getPassword())==false){
                   return "invaild password";
                }
                if(register.checkPhoneNumber(register.getNumberPhone())==false){
                    return "invaild numberPhone";
                }
            }
        }
        String sql1="INSERT INTO users(Phone,Email,Password)VALUE ('"+register.getNumberPhone()+"','"+register.getEmail()+"','"+register.getPassword()+"')";
        statement.execute(sql1);
        return "Register Successed";
    }

}




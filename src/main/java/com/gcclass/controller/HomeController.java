package com.gcclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.sql.SQLException;

@Controller
public class HomeController {

    /**
     * @RequestMapping("/") public ModelAndView helloWorld() {
     * return new
     * ModelAndView("welcome", "message", "HELLO ADAM!");
     * }
     **/

    @RequestMapping("welcome")

    public ModelAndView helloWorld2() {

        int[] ar = {1, 2, 3, 4};
        return new ModelAndView("welcome2", "message", ar);

    }
    @RequestMapping(value = {"dbReturn", "/"})
    public ModelAndView DBReturn() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/gcbc";
        String userName = "chirpus";
        String password = "grant";
        String query = "select * FROM product";

        //STEP 1 add imports at the top

        //STEP 2 LOAD AND REGISTER DRIVER
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3 CREATE CONNECTION
        Connection con = DriverManager.getConnection(url, userName, password);

        //STEP 4 CREATE STATEMENT
        Statement st = con.createStatement();

        //STEP 5 RETRIEVE RESULTS
        ResultSet rs = st.executeQuery(query);
        rs.next();

        //STEP 6 PROCESS RESULTS
        String code = rs.getString("code");
        String discription = rs.getString("description");
        String format = code + " " + discription;

        //STEP 7 CLOSE CONNECTION
        st.close();
        con.close();

        return new
                ModelAndView("dbReturn", "WeiDB", format);

    }

}

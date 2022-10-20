package id.co.bca.springtutorial.HelloWorld.datasource;

import id.co.bca.springtutorial.HelloWorld.model.EmployeeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySQLDataSource {
    //pengecekan apakah dengan mysql sudah terhubung apa blm
    public static final Logger LOGGER =  LoggerFactory.getLogger(MySQLDataSource.class.getName());

    //state nama database
    //ini contoh kalau make mysql
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_directory";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASS = "";

    public static final String STM_CREATE = "INSERT INTO employee (first_name, last_name, email, date, time, timestamp) VALUES (?, ?, ?, ?, ?, ?);"; //statement query create data
    // tanda tanya (?) digunakan sebagai prestatement untuk mengganti parameter
    public static final String STM_UPDATE = "UPDATE employee SET first_name = ?, last_name = ?, email = ? date = ?, time = ?, timestamp = ? WHERE employee.id = ?;";
    public static final String STM_RETRIEVE_ALL = "SELECT * FROM EMPLOYEE;";
    public static final String STM_RETRIEVE_BY_ID = "SELECT * FORM EMPLOYEE WHERE ID = ?";
    public static final String STM_DELETE_BY_ID = "DELETE FORM EMPLOYEE WHERE ID = ?";

    public MySQLDataSource(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            LOGGER.info("Connection Successfull");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.info("Connection Failed");
        } finally {
                try { if (connection != null) {connection.close(); } } catch (SQLException e) {}
        }
    }

    public void insertEmployee(EmployeeModel employee){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            LOGGER.info("Connection Successfull");
            ps = connection.prepareStatement(STM_CREATE);
            //tanda tanya di STM_CREATE akan di isi dengan setString sesuai dengan urutan indexnya
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            //belum di tambahin 3 param lainnya
            ps.execute();
            LOGGER.info("Input Success");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.info("Connection Failed");
            LOGGER.info("Input Failed");
        }finally {
            try { if (connection != null) {connection.close(); } } catch (SQLException e) {}
        }
    }

    public void updateEmployee(EmployeeModel employee){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            LOGGER.info("Connection Successfull");
            ps = connection.prepareStatement(STM_UPDATE);
            //tanda tanya di STM_CREATE akan di isi dengan setString sesuai dengan urutan indexnya
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setInt(4, employee.getId());

            ps.execute();
            LOGGER.info("Update Success");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.info("Connection Failed");
            LOGGER.info("Update Failed");
        }finally {
            try { if (connection != null) {connection.close(); } } catch (SQLException e) {}
        }
    }

    public List<EmployeeModel> getAllEmployee(){
        List<EmployeeModel> employees = new ArrayList<>();
        Connection connection = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            LOGGER.info("Connection Successfull");
            s = connection.createStatement();
            rs =  s.executeQuery(STM_RETRIEVE_ALL);
            while(rs.next()){
                int id = rs.getInt("id");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String email = rs.getString("email");
                EmployeeModel model = new EmployeeModel();
                model.setId(id);
                model.setFirstName(firstname);
                model.setLastName(lastname);
                model.setEmail(email);
                employees.add(model);
            }
            LOGGER.info("get All Success");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.info("Connection Failed");
            LOGGER.info("get All Failed");
        }finally {
            try { if (connection != null) {connection.close(); } } catch (SQLException e) {}
        }
        return employees;
    }
}

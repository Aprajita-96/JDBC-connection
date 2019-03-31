package com.stackroute.jdbcdemo;

import java.sql.*;

public class UserManager {

    private Connection connection;


    public UserManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/userdb";
            connection = DriverManager.getConnection(url,"root","Root@123");
        }
        catch (Exception e){

        }

    }


    public  void displayAllUser() throws Exception{
        // Registers Driver with driverManager

       Statement statement =  connection.createStatement();
       ResultSet resultSet = statement.executeQuery("SELECT * FROM usertbl");

       while (resultSet.next()){
          int id =  resultSet.getInt(1);
          String name = resultSet.getString(2);
          int age = resultSet.getInt(3);
           System.out.println("id name is :"+id + "name:"+name +"age:"+ age);
       }
    }



    public void displayUserByName(String name) throws  Exception{

        PreparedStatement preparedStatement =  connection.prepareStatement("select  * from usertbl where name = ? ");
        preparedStatement.setString(1,name);
       ResultSet resultSet =  preparedStatement.executeQuery();

        while (resultSet.next()){

            String username = resultSet.getString(2);

            System.out.println("id name is :"+username);
        }

    }

    // insert user

    public void insertUser(int id,String name,int age)throws Exception{

        PreparedStatement preparedStatement=connection.prepareStatement("insert into usertbl"+
                "(userid,username,userage)values"+
                "(?,?,?)");
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"Akansha");
        preparedStatement.setInt(3,25);
        preparedStatement.executeUpdate();


        }



    // Delete user by name
    public void deleteUserByName(String name) throws Exception{
        PreparedStatement preparedStatement=connection.prepareStatement("delete from usertbl where username=?");
        preparedStatement.setString(1,name);
        preparedStatement.executeUpdate();

    }

    // Update user age

    public void updateUserAge(int id,int newAge) throws Exception{
        PreparedStatement preparedStatement=connection.prepareStatement("update usertbl set userage=? where userid=?");
        preparedStatement.setInt(1,newAge);
        preparedStatement.setInt(2,id);
        preparedStatement.execute();

    }

    


}

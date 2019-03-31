package com.stackroute.jdbcdemo;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        try {
          //  userManager.displayAllUser();
//            userManager.displayUserByName("aman");
//            userManager.insertUser(4,"Akansha",23);
//            userManager.deleteUserByName("Akansha");
            userManager.updateUserAge(3,24);
        }

        catch (Exception e){
            System.out.println(e);
        }
    }
}

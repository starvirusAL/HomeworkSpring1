package app.custom;

import app.Account;

import java.util.List;

public class FormatedPersonal {
     public static String formated(int id, String name,  String email, int age,List<Account> accounts){



         return String.format("""
           Personal id: %s
           
           Name: %s
           E-mail: %s
           Age: %s
                 
           Accounts: %s      
                 
                 """, id,name,email,age,accounts)     ;
    }
}

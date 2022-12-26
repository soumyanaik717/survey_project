package survey;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class user {
     admin obj=new admin();
     String user1;
     String user2;
    String user3;
     String user4;
     String user5;

     user(){

     }

    user(String val1,String val2,String val3,String val4,String val5)
    {
        this.user1=val1;
        this.user2=val2;
        this.user3=val3;
        this.user4=val4;
        this.user5=val5;
    }
   public void insert_table(String name){



        try {
           // System.out.println(user1);
            //System.out.println(name);

            String query = "INSERT INTO "+name+"  values(?,?,?,?,?)";
            PreparedStatement ps = Jdbc.connectionDB().prepareStatement(query);
            ps.setString(1,user1);
            ps.setString(2,user2);
            ps.setString(3,user3);
            ps.setString(4,user4);
            ps.setString(5,user5);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
   }
   public void delete_row(String table_name,String column_name,String user_name){
         System.out.println(table_name);
         System.out.println(column_name);
         System.out.println(user_name);


         try{
             String query= "delete from "+table_name+" where "+column_name+" ='"+user_name+"' ";
             PreparedStatement ps = Jdbc.connectionDB().prepareStatement(query);
             ps.executeUpdate();
             System.out.println("deleted");
         }catch (Exception e){
             e.printStackTrace();
         }

   }
   public void drop_table(String table_drop) throws SQLException, ClassNotFoundException {
       String query= "drop table " +table_drop+" ";
       PreparedStatement ps = Jdbc.connectionDB().prepareStatement(query);
       ps.executeUpdate();
       System.out.println("deroped");


   }
}







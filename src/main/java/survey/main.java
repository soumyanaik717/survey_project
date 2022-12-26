package survey;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class main {
    public static void main(String[] args) throws IOException {


        admin obj = new admin();
        user u = new user();

        Scanner sc = new Scanner(System.in);
        String option[]=new String[0];
        while (true) {


            System.out.println("1" + "--" + "Admin");
            System.out.println("2" + "--" + "User");
            System.out.println("Enter the choice : ");

            int val = sc.nextInt();

            if (val == 1) {


                System.out.println(1 + " crate   a table ");
                System.out.println(2 + " update the table");
                System.out.println(3 + " delete the row");
                System.out.println(4 + " drop the table");
                System.out.println("enter your task no");
                int task = sc.nextInt();
                switch (task) {

                    case 1:
                        System.out.println("enter the meta data of the question: ");
                        String meta_data = sc.next();
                        System.out.println("enter the question :");
                        sc.next();
                        String question = sc.nextLine();
                        System.out.println("enter the field 1");
                        String val1 = sc.nextLine();
                        System.out.println("enter the field 2");
                        String val2 = sc.nextLine();
                        System.out.println("enter the field 3");
                        String val3 = sc.nextLine();
                        System.out.println("enter the field 4");
                        String val4 = sc.nextLine();
                        System.out.println("In the field 5 how many option you need");
                        int val5 = sc.nextInt();
                        option = new String[val5];
                        for (int i = 0; i < val5; i++) {
                            System.out.println("enter " + (i + 1) + " option");
                            // sc.next();
                            option[i] = sc.next();


                        }

                        obj = new admin(meta_data, question, val1, val2, val3, val4, option);
                        //obj=new admin(option);
                        // obj.print();
                        // System.out.println(option.length);
                        obj.create_table();

                        // System.out.println(option[0]);

                        //break;
                    case 2:
                        break;


                    case 3:
                        String user_name;
                        System.out.println("Enetr the user name to delete");
                        user_name= sc.next();
                        u.delete_row(obj.meta_data,obj.val1,user_name);

                        break;

                    case 4:
                        try {

                            DatabaseMetaData dbmd = Jdbc.connectionDB().getMetaData();
                            String[] types = {"TABLE"};
                            ResultSet rs = dbmd.getTables(null, null, "%", types);
                            System.out.println("Tables in the current database: ");
                            while (rs.next()) {
                                System.out.println(rs.getString("TABLE_NAME"));
                            }
                            String table_drop;
                            System.out.println("Enter the table you want to drop");
                            table_drop=sc.next();
                            u.drop_table(table_drop);



                        }
                        catch(Exception e){e.printStackTrace();}

                        break;

                    default:

                }


            } else if (val == 2) {
                System.out.println("enter the field 1 : " + obj.val1);
                String u1 = sc.next();
                //sc.next();
                System.out.println("enter the field 2 : " + obj.val2);
                String u2 = sc.next();
                //sc.next();
                System.out.println("enter the field 3 :" + obj.val3);
                String u3 = sc.next();
                //sc.next();
                System.out.println("enter the field 4 : " + obj.val4);
                String u4 = sc.next();
                //sc.next();

                for(int i=0;i< option.length;i++){
                      System.out.println(option[i]);
                  }
                System.out.println("enter your ans");
                String u5 = sc.next();
                //sc.next();

                //System.out.println(u1);

                u = new user(u1, u2, u3, u4, u5);
                u.insert_table(obj.meta_data);


            }
        }

    }
}



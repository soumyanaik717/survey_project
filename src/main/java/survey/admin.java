package survey;
import java.sql.PreparedStatement;

public class admin {

    String meta_data;
     String question;
     String val1;
    String val2;
     String val3;
    String val4;
     int var5;
     String option[];
     String val6 = "Choice";

    admin(){

    }
//String meta_data, String question, String val1, String val2, String val3, String val4,
    admin( String meta_data, String question, String val1, String val2, String val3, String val4,String option[]) {
        this.meta_data = meta_data;
        this.question = question;
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
        this.option=option;
    }

//    public void print(){
//        for(int i=0;i< option.length;i++){
//            System.out.println(option[i]);
//        }
//    }

    public void create_table() {
        try {

                String query = "Create table " + meta_data +
                        "("+val1+" VARCHAR(255), " +
                        val2 +" VARCHAR(255), " +
                        val3 +" VARCHAR(255), " +
                        val4 +" VARCHAR(255), " +
                       val6 +" VARCHAR(255) " +
                        ")";
                PreparedStatement ps = Jdbc.connectionDB().prepareStatement(query);
                ps.execute();

            }catch(Exception e){
                e.printStackTrace();
            }

        }
        public String[] get_option(){
        return option;
        }




    }






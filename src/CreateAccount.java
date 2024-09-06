import java.io.*;

public class CreateAccount {

    static String userNAME;
    static String userSURNAME;
    static int userAGE;
    static String userNICKNAME;
    private static String userPASSWORD;

    public static String getUserPASSWORD() {
        return userPASSWORD;
    }

    public static void setUserPASSWORD(String userPASSWORD) {
        CreateAccount.userPASSWORD = userPASSWORD;
    }

    public static void Write(String filepath, String name,String surname,String nickname,String age,String password){
        try {
            File file = new File(filepath);

            PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
            pw.println(name+" "+surname+" "+nickname+" "+age+" "+password);
            pw.close();


        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }

}

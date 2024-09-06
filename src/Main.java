

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static boolean usernameSIGN_IN(String filepath, String userNAME) throws FileNotFoundException {
        DataMatrix dM = new DataMatrix();
        String[][] array = dM.Matrix(filepath);
        for (int y = 0; y < dM.Matrixline(filepath); y++) {

            if (userNAME.equals(array[y][2])) {
                return true;
            }
        }
        return false;
    }


    public static boolean userpasswordSIGN_IN(String filepath, String userNAME, String userPASSWORD) throws FileNotFoundException {
        DataMatrix dM = new DataMatrix();
        String[][] array = dM.Matrix(filepath);
        int line = -1;


        for (int y = 0; y < dM.Matrixline(filepath); y++) {
            if (userNAME.equals(array[y][2])) {
                line = y;
                break;
            }
        }


        if (line != -1 && array[line][4].equals(userPASSWORD)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\HP\\Desktop\\software\\JavaUserProject\\src\\UserDatas.txt");
        Scanner scanner = new Scanner(System.in);
        CreateAccount create = new CreateAccount();
        System.out.println("-----------------------------");
        System.out.println("1-Sign In");
        System.out.println("2-Create Your Account");
        System.out.println("3-Exit");
        System.out.println("-----------------------------");
        System.out.print("Please select the action: ");

        short action = scanner.nextShort();
        scanner.nextLine();
/////////////////////////////////////////////////////SIGN IN////////////////////////////////////////////////////////////
        if (action == 1) {
            System.out.println("-----------------------------");
            System.out.println("          Sign In            ");
            System.out.println("-----------------------------");

            System.out.print("Nickname: ");
            String userNICkNAME = scanner.nextLine();

            if (usernameSIGN_IN(String.valueOf(file), userNICkNAME)) {
                System.out.println("-----------------------------");
                System.out.print("Password: ");
                String userPASSWORD = scanner.nextLine();

                int attempts = 0;
                final int maxAttempts = 3;


                while (!userpasswordSIGN_IN(String.valueOf(file), userNICkNAME, userPASSWORD) && attempts < maxAttempts) {
                    attempts++;
                    System.out.println("!Wrong Password! Try again. (" + attempts + "/" + maxAttempts + ")");
                    if (attempts < maxAttempts) {
                        System.out.print("Password: ");
                        userPASSWORD = scanner.nextLine();
                    }
                }

                if (attempts == maxAttempts) {
                    System.out.println("Too many failed attempts. Access denied.");
                } else {
                    System.out.println("Welcome Back " + userNICkNAME);
                }
            } else {
                System.out.println("!User not found!");
            }
        }

/////////////////////////////////////////////Create Your Account////////////////////////////////////////////////////////
        if(action==2){

            System.out.println("-----------------------------");
            System.out.println("    Create Your Account     ");

            System.out.print("Name: ");
                String name = scanner.next();
                create.userNAME=name;
                scanner.nextLine();

            System.out.print("Surname: ");
                String surname = scanner.next();
                create.userSURNAME=surname;
                scanner.nextLine();

            System.out.print("Age: ");
                int age = scanner.nextInt();
                create.userAGE=age;

            if(age<18){
                while (age<18){
                    System.out.println("! Your age must be over 18 !");
                    System.out.print("Age: ");
                    age=scanner.nextInt();
                }
            }

            System.out.print("Nickname: ");
                String nickname = scanner.next();
                create.userNICKNAME = nickname;

            System.out.print("Password: ");
                String password = scanner.next();
                CreateAccount.setUserPASSWORD(password);

            create.Write(String.valueOf(file),name,surname,nickname,String.valueOf(age),password);
            System.out.println("Welcome "+name+" "+surname);
        }
//////////////////////////////////////////////////////EXİT//////////////////////////////////////////////////////////////

        if (action==3){
            System.out.println("BYE BYE");
        }

    }
}
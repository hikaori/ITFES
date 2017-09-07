package Itfes;

import java.util.Scanner;

/**
 * Created by kaorihirata on 2017-04-19.
 */
public class LoginAndRegisterPage extends DispPageClass implements Validate {

    public void dispPage(){
        Scanner scan = new Scanner(System.in);
        UserControlClass ucc = new UserControlClass();

        System.out.println("this is LoginAndRegisterPage");
        System.out.println("Choose and Enter sign up(0)/ sign in(1) / linkedIn(2)");
        int login = scan.nextInt();
        scan.nextLine(); // (It consumes the \n character)

        switch (login) {
            case 0: // (0) sign up
                System.out.println("put name");
                String liName = scan.nextLine();
                System.out.println("put eMail");
                String liEmail = scan.nextLine();
                System.out.println("put password");
                String liPassword = scan.nextLine();
                System.out.println("put category");
                String liCategory = scan.nextLine();


                if(this.validate(liName, liEmail,liPassword, liCategory)){
                    boolean uccResult = ucc.newRegister(liName, liEmail,liPassword,liCategory);
                    if (uccResult) System.out.println("Create account successful");
                    else System.out.println(liName +" already exists");
                }else{
                    System.out.println("Input again!!");
                }

                this.dispPage();
                break;
            case 1: // (1) sign in
                System.out.println("put Email");
                String siEmail = scan.nextLine();
                System.out.println("put password");
                String siPassword = scan.nextLine();

                boolean userCheckResult = ucc.login(siEmail,siPassword);
                if (userCheckResult) System.out.println("Login successful");
                else {
                    System.out.println("Login fail");
                    this.dispPage();
                }
                break;
            case 2: // (2) LinkedIn
                ucc.newRegister("LinkedIn", "LinkedIn@link.com","LinkedIn","LinkedIn");
                System.out.println("Login with LinkedIn");
                break;
            default:
                System.out.println("Error LoginAndRegisterPage");
        }
    }

    @Override
    public boolean validate(String name, String email, String password, String category) {

        if (name.equals("")) {
            System.out.println("Name is empty");
            return false;
        }

        //check mail address
        String MATCH_MAIL = "([a-zA-Z0-9][a-zA-Z0-9_.+\\-]*)@(([a-zA-Z0-9][a-zA-Z0-9_\\-]+\\.)+[a-zA-Z]{2,6})";

        if (!email.matches(MATCH_MAIL)) {
            System.out.println("Email Address in invalid format");
            return false;
        }

        //check password
        if (password.length()< 4){
            System.out.println("Password is short!!");
            return false;
        }

        if (category.equals("")) {
            System.out.println("Category is empty");
            return false;
        }

        return true;
    }

    @Override
    public boolean validate(String eventName, String location, String date, String time, String description) {
        return false;
    }
}


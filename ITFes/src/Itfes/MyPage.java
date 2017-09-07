package Itfes;

import java.util.Scanner;

/**
 * Created by madoka on 2017/04/19.
 */
public class MyPage extends DispPageClass implements Validate {

    public void dispPage() {

        UserControlClass ucc = new UserControlClass();
        DisplayPageClass dpc = new DisplayPageClass("MyPage");

        System.out.println("press View Your Event list(0) / Edit profile(1) / menu(99)");

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();

        switch (num) {
            case 0: //Display User Event list
                //System.out.println(Arrays.asList(ucc.getUserAccount()));
                dpc.displayUserAccount(ucc.getUserAccount());
                dpc.displayEventList(ucc.getUserEvent());

                this.dispPage();
                break;

            case 1: //UserDate RenewAccount()
                System.out.println("put name");
                String name = scan.nextLine();
                System.out.println("put Email");
                String email = scan.nextLine();
                System.out.println("put password");
                String password = scan.nextLine();
                System.out.println("put category");
                String category = scan.nextLine();

                if(validate(name, email, password, category)){
                    boolean result = ucc.RenewAccount(name, email, password, category);
                    if (result) System.out.println("Renew account successful");
                    else System.out.println("error");
                }else{
                    System.out.println("Input again!!");
                }

                this.dispPage();
                break;
            case 99://call menu
                this.callMenu();
                break;

            default:
                System.out.println("error");

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

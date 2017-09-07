package Itfes;

import java.util.Scanner;

/**
 * Created by kaorihirata on 2017-04-19.
 */
public class PostEventPage extends DispPageClass implements Validate {

    public void dispPage() {
        DisplayPageClass dpc = new DisplayPageClass("PostEventPage");
        System.out.println("choose Post event(0) / Cancel(1) / menu(99)");

        Scanner scan = new Scanner(System.in);
        int chPage = scan.nextInt();
        scan.nextLine();
        switch (chPage) {
            case 0:
                System.out.println("Enter EventName");
                String eventName = scan.nextLine();
                System.out.println("Enter Location");
                String location = scan.nextLine();
                System.out.println("Enter Date EX)May 5 Mon");
                String date = scan.nextLine();
                //add EX)
                System.out.println("Enter Time  EX)HH:MM");
                String time = scan.nextLine();
                System.out.println("Enter Description");
                String description = scan.nextLine();

                if (this.validate(eventName, location, date, time, description)) {
                    EventControlClass ecc = new EventControlClass();
                    boolean posEveResult = ecc.postEvent(eventName, location, date, time, description);
                    if (posEveResult) System.out.println("Event saved");
                    else System.out.println("Event couldn't save");
                }else{
                    //add "\n"
                    System.out.println("\n");
                    System.out.println("Input again!!\n");
                }

                this.dispPage();
                break;
            case 1:
                MyPage mp = new MyPage();
                mp.dispPage();
                break;
            case 99:
                this.callMenu();
                break;
            default:
                System.out.println("error");
        }

    }

    @Override
    public boolean validate(String name, String email, String password, String category) {
        return false;
    }

    @Override
    public boolean validate(String eventName, String location, String date, String time, String description) {

        // check value is not ""

        if (eventName.equals("")) {
            System.out.println("Event name is empty");
            return false;
        }

        if (location.equals("")) {
            System.out.println("location is empty");
            return false;
        }

        if (date.equals("")) {
            System.out.println("date is empty");
            return false;
        }

        if (time.equals("")) {
            System.out.println("time is empty");
            return false;
        }

        if (time.equals("")) {
            System.out.println("description is empty");
            return false;
        }

        //check time
        String MATCH_TIME = ("^([0-1][0-9]|[2][0-3]):[0-5][0-9]$");
        if (!time.matches(MATCH_TIME)){
            System.out.println("Time is not Right Form");
            return false;
        }

        return true;

    }
}

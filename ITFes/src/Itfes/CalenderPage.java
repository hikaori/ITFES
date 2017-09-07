package Itfes;

import java.util.Scanner;

/**
 * Created by madoka on 2017/04/19.
 */
class CalendarPage extends DispPageClass {

    public void dispPage() {

        Scanner scan = new Scanner(System.in);

        EventControlClass ecc = new EventControlClass();
        UserControlClass ucc = new UserControlClass();
        DisplayPageClass dpc = new DisplayPageClass("CalendarPage");
        System.out.println("press allEvent(0) / myEvent(1) / menu(99)");

        // tabMenu -> scan
        Scanner tabMenu = new Scanner(System.in);
        int num = tabMenu.nextInt();

        switch (num) {
            case 0: //Display All Event
                //Display event information
                //System.out.println(Arrays.deepToString(ecc.getUpcomingEvents()));
                dpc.displayEventList(ecc.getUpcomingEvents());
                break;
            case 1: //Display User's Event
                //Display event information
                if(ucc.getUserEvent()[0][0] == null)System.out.println("-Nothing to join your events-");
                else dpc.displayEventList(ucc.getUserEvent());
                break;
            case 99://Call Menu
                this.callMenu();
                break;
            default:
                System.out.println("error");
        }

        System.out.println("Do you want to finish app? Yes(0)/No(1)");
        int finishFlg = scan.nextInt();
        if(finishFlg == 0) return;
        else{
            CalendarPage cp = new CalendarPage();
            cp.dispPage();
        }
    }
}

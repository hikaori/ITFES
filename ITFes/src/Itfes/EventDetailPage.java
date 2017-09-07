package Itfes;

import java.util.Scanner;

public class EventDetailPage extends DispPageClass {

    private int event_type, eventID;
    EventControlClass ecc = new EventControlClass();
    Scanner scan = new Scanner(System.in);

    public EventDetailPage(int event_type, int eventID){
        // EventID check it exists or not
        for (;;){
            if(ecc.searchExistEvent(event_type,eventID)) break;
            eventID = scan.nextInt();
        }

        this.event_type = event_type;
        this.eventID = eventID;
    }

    public void dispPage(){

        //System.out.println("this is EventDetailPage");
        // ここでthis is *** page 表示
        DisplayPageClass dpc = new DisplayPageClass("EventDetailPage");
        System.out.println("Choose one of this EventDetail(0) / back to Main page(1) / menu(99)");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        switch (num) {
            case 0: // (0)show EventDetail
                // System.out.println(Arrays.asList(ecc.getEventDetail(event_type, this.eventID)));
                // ここで整形したEventDetail表示
                dpc.displayEventDetail(ecc.getEventDetail(event_type, this.eventID));

                this.chJoin();
                break;
            case 1:
                MainPage mp = new MainPage();
                mp.dispPage();
                break;
            case 99://Call Menu
                this.callMenu();
                break;
            default:
                System.out.println("error");
        }
    }

    public void chJoin(){
        System.out.println("Enter if you want to join(0) not (1)");
        Scanner scan = new Scanner(System.in);
        int chJoin = scan.nextInt();
        if (chJoin == 0){

            UserControlClass ucc = new UserControlClass();
            System.out.println("Enter EventID you want to join");
            boolean eventJoin = ucc.setUserEvent(scan.nextInt());
            if (eventJoin){
                System.out.println("join successful");
            }else{
                System.out.println("join err");
            }
        }else{
            // chJoin = 1  (何もしない)
        }
        this.dispPage();
    }
}

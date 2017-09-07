/**
 * Created by madoka on 2017/04/19.
 */
package Itfes;

import java.util.Scanner;

public class MainPage extends DispPageClass {
    public void dispPage() {
        //add
        EventControlClass ecc = new EventControlClass();
        int num, gotoDetail;
        //add DisplayPageClass
        DisplayPageClass dpc = new DisplayPageClass("MainPage");

        System.out.println("press UpComing(0) / You May Like(1) / menu(99)");

        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();

        switch (num) {
            case 0: //Display upComing Event
                //Display event information
                //System.out.println(Arrays.deepToString(ecc.getUpcomingEvents()));
                dpc.displayEventList(ecc.getUpcomingEvents());
                System.out.println("\nGo to event detail page(0) / No(1)");
                gotoDetail = scan.nextInt();

                if(gotoDetail == 0){
                    // go to detail page
                    System.out.println("[DebugMode] Enter EventID ");
                    EventDetailPage edp = new EventDetailPage(0, scan.nextInt());
                    edp.dispPage();
                }else{
                    this.dispPage();
                }
                break;

            case 1: //Display You May Like Event
                //Display event information
                //System.out.println(Arrays.deepToString(ecc.getRecommendEvents()));
                dpc.displayEventList(ecc.getRecommendEvents());
                System.out.println("\nGo to event detail page(0) / No(1)");
                gotoDetail = scan.nextInt();

                if(gotoDetail == 0){
                    // go to detail page
                    System.out.println("[DebugMode] Enter EventID ");
                    EventDetailPage edp = new EventDetailPage(1, scan.nextInt());
                    edp.dispPage();
                }else{
                    this.dispPage();
                }
                break;

            case 99://Call Menu
                this.callMenu();
                break;

            default:
                System.out.println("error");

        }
    }
}

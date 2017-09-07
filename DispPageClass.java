package Itfes;

import java.util.Scanner;

/**
 * Created by madoka on 2017/04/19.
 */
abstract class DispPageClass {

    public abstract void dispPage();

    public void callMenu() {

        System.out.println("---Menu---");
        System.out.println("choose My page(0) / Calendar(1) / Post event page(2) / Main page(3)");
        Scanner pg = new Scanner(System.in);
        int chPage = pg.nextInt();

        switch (chPage) {
            case 0:
                MyPage myp = new MyPage();
                myp.dispPage();
                break;
            case 1:
                CalendarPage cp = new CalendarPage();
                cp.dispPage();
                break;
            case 2:
                PostEventPage pep = new PostEventPage();
                pep.dispPage();
                break;
            case 3:
                MainPage mp = new MainPage();
                mp.dispPage();
                break;
            default:
                System.out.println("error");
        }

    }


}



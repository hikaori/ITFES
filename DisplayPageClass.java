package Itfes;

/**
 * Created by madoka on 2017/04/23.
 */
public class DisplayPageClass {
    // コンストラクタ
    public DisplayPageClass(String pageTitle) {
        System.out.println("This is " + pageTitle);
    }

    // for array
    public void displayEventDetail(String[] eventDetailArray) {
        System.out.println("---Event detail---");
        //for(int i=0;i<eventDetailArray.length;i++){
        // EventIDは表示しない
        // if(i == 0) continue;
        System.out.println(eventDetailArray[0]);
        System.out.println("Month: " + eventDetailArray[1]);
        System.out.println("Day: " + eventDetailArray[2]);
        System.out.println("Time: " + eventDetailArray[3]);
        System.out.println("Location: " + eventDetailArray[4]);
        System.out.println("EventName: " + eventDetailArray[5]);
        System.out.println("Description: " + eventDetailArray[6]);
        System.out.println("\n");
        //}
    }

    // for dimension array
    public void displayEventList(String[][] eventListArray) {
        System.out.println("---Event list---");

        for(int i=0;i<eventListArray.length;i++){
            if(eventListArray[i][0] == null) continue;
            System.out.println(eventListArray[i][0]);
            System.out.println("Month: " + eventListArray[i][1]);
            System.out.println("Day: " + eventListArray[i][2]);
            System.out.println("Time: " + eventListArray[i][3]);
            System.out.println("Location: " + eventListArray[i][4]);
            System.out.println("EventName: " + eventListArray[i][5]);
            // 次のイベント表示へ
            System.out.println("-------------");

        }

    }

    public void displayUserAccount(String[] userAccountArray){
        System.out.println("---Your account information---");
        System.out.println("Name: " +userAccountArray[0]);
        System.out.println("e-mail: " +userAccountArray[1]);
        System.out.println("Category: " +userAccountArray[3] +"\n");
    }

}


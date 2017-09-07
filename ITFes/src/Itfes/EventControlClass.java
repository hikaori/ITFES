package Itfes;

/**
 * Created by Nobuaki on 2017-04-19.
 */
public class EventControlClass {

    public String[][] getUpcomingEvents(){
        /** It'll change to DB **/
        String[][] upComingEventsArray;
        // TEST event data
        upComingEventsArray = this.makeTestData(0);
        return upComingEventsArray;
    }

    public String[][] getRecommendEvents(){
        /** It'll change to DB **/
        String[][] recommendEventsArray;
        recommendEventsArray = this.makeTestData(1);
        return recommendEventsArray;
    }

    public String[] getEventDetail(int event_type, int eventID){
        // It'll change to DB

        /**
         * event_type: 0 = upcoming, 1 = you may like
         */

        String[] eventDetail = new String[7];
        String[][] eventList; // サンプルのイベントリストを入れる

        if(event_type == 0)  eventList = this.makeTestData(0); // upcoming event
        else eventList = this.makeTestData(1); // recommend event

        for(int i=0;i<eventList.length;i++){
            if(eventID == Integer.parseInt(eventList[i][0])){
                for(int j=0; j<eventDetail.length;j++){
                    eventDetail[j] = eventList[i][j];
                }
                return eventDetail;
            }
        }

        System.out.println("EventID is not found !!");
        eventDetail[0] = "Error !!";
        return eventDetail;
    }

    public boolean postEvent(String eventName, String location,String data, String time, String description){
        /** It'll change DB function */
        return this.setPostedUserEvent(eventName, location, data, time, description);
    }

    public boolean searchExistEvent(int event_type, int eventID){
        String[][] eventListArray;
        if(event_type ==0){
            eventListArray = this.makeTestData(0);
        } else {
            eventListArray = this.makeTestData(1);
        }

        for(int i=0;i<eventListArray.length;i++){
            if(eventID == Integer.parseInt(eventListArray[i][0])) return true;
        }

        System.out.println(eventID +"  is not found.");
        System.out.println("Please enter correct event ID");
        return false;
    }


    /**
     * -------------------------------------------------------------
     * We don't have database so we can't save userData, eventData.
     * This class can save above data tentatively.
     *
     * We'll replace these method with Database.
     * -------------------------------------------------------------
     */


    public String[][] makeTestData(int testDataType){
        //String[][] testDataArray = new String[5][7];
        String[][] testDataArray;

        if(testDataType == 1) testDataArray = new String[3][7];
        else testDataArray = new String[5][7];
        /**
         * EventID、曜日、日付、時間、場所、イベント名、詳細
         */
        switch (testDataType) {
            case 0: // upcoming events
                testDataArray = new String[5][7];
                testDataArray[0][0] = "1";
                testDataArray[0][1] = "May";
                testDataArray[0][2] = "5";
                testDataArray[0][3] = "9:00 - 10:00";
                testDataArray[0][4] = "Vancouver BC";
                testDataArray[0][5] = "Women Code";
                testDataArray[0][6] = "Welcome Coders for Free technical study !!";

                testDataArray[1][0] = "2";
                testDataArray[1][1] = "Jun";
                testDataArray[1][2] = "2";
                testDataArray[1][3] = "12:00 - 13:00";
                testDataArray[1][4] = "Montreal QC";
                testDataArray[1][5] = "Men Code";
                testDataArray[1][6] = "Welcome Coders for Hack events !!";

                testDataArray[2][0] = "3";
                testDataArray[2][1] = "Sep";
                testDataArray[2][2] = "10";
                testDataArray[2][3] = "18:00 - 19:00";
                testDataArray[2][4] = "Nelson BC";
                testDataArray[2][5] = "pika-chu Code";
                testDataArray[2][6] = "Let's gotcha a Pika-chu";

                testDataArray[3][0] = "4";
                testDataArray[3][1] = "Mar";
                testDataArray[3][2] = "31";
                testDataArray[3][3] = "19:00 - 20:00";
                testDataArray[3][4] = "Kelowna BC";
                testDataArray[3][5] = "ciccc Code";
                testDataArray[3][6] = "Studying with International Students";

                testDataArray[4][0] = "5";
                testDataArray[4][1] = "Apr";
                testDataArray[4][2] = "25";
                testDataArray[4][3] = "19:30 - 20:30";
                testDataArray[4][4] = "Vancouver BC";
                testDataArray[4][5] = "Awesome Code";
                testDataArray[4][6] = "Every Code Awesome";

                break;
            case 1: // RecommendEventsData
                testDataArray[0][0] = "99";
                testDataArray[0][1] = "Fev";
                testDataArray[0][2] = "24";
                testDataArray[0][3] = "10:00 - 12:00";
                testDataArray[0][4] = "Vancouver BC";
                testDataArray[0][5] = "java Code";
                testDataArray[0][6] = "Welcome Coders for Free technical study !!";

                testDataArray[1][0] = "100";
                testDataArray[1][1] = "Jan";
                testDataArray[1][2] = "15";
                testDataArray[1][3] = "15:00 - 16:00";
                testDataArray[1][4] = "Prince Rupert BC";
                testDataArray[1][5] = "web Code";
                testDataArray[1][6] = "Welcome Coders for Hack events !!";

                testDataArray[2][0] = "200";
                testDataArray[2][1] = "Sep";
                testDataArray[2][2] = "10";
                testDataArray[2][3] = "21:00 - 22:00";
                testDataArray[2][4] = "Nelson BC";
                testDataArray[2][5] = "Coffee Code";
                testDataArray[2][6] = "Let's gotcha a Pika-chu";
                break;
            case 2: // userEvents
                testDataArray[0][0] = "1000";
                testDataArray[0][1] = "Fev";
                testDataArray[0][2] = "24";
                testDataArray[0][3] = "10:00 - 12:00";
                testDataArray[0][4] = "Vancouver BC";
                testDataArray[0][5] = "java Code";

                testDataArray[1][0] = "2000";
                testDataArray[1][1] = "Jan";
                testDataArray[1][2] = "15";
                testDataArray[1][3] = "15:00 - 16:00";
                testDataArray[1][4] = "Prince Rupert BC";
                testDataArray[1][5] = "web Code";

                testDataArray[2][0] = "3000";
                testDataArray[2][1] = "Sep";
                testDataArray[2][2] = "10";
                testDataArray[2][3] = "21:00 - 22:00";
                testDataArray[2][4] = "Nelson BC";
                testDataArray[2][5] = "Coffee Code";
                break;
            case 3:// eventDetail
                testDataArray[0][0] = "9999";
                testDataArray[0][1] = "May";
                testDataArray[0][2] = "5";
                testDataArray[0][3] = "9:00 - 10:00";
                testDataArray[0][4] = "Vancouver BC";
                testDataArray[0][5] = "Women Code";
                testDataArray[0][6] = "Welcome Coders for Free technical study !!";

                testDataArray[1][0] = "10000";
                testDataArray[1][1] = "Jun";
                testDataArray[1][2] = "2";
                testDataArray[1][3] = "12:00 - 13:00";
                testDataArray[1][4] = "Montreal QC";
                testDataArray[1][5] = "Men Code";
                testDataArray[1][6] = "Welcome Coders for Hack events !!";

                testDataArray[2][0] = "20000";
                testDataArray[2][1] = "Sep";
                testDataArray[2][2] = "10";
                testDataArray[2][3] = "18:00 - 19:00";
                testDataArray[2][4] = "Nelson BC";
                testDataArray[2][5] = "pika-chu Code";
                testDataArray[2][6] = "Let's gotcha a Pika-chu";

                testDataArray[3][0] = "30000";
                testDataArray[3][1] = "Mar";
                testDataArray[3][2] = "31";
                testDataArray[3][3] = "19:00 - 20:00";
                testDataArray[3][4] = "Kelowna BC";
                testDataArray[3][5] = "ciccc Code";
                testDataArray[3][6] = "Studying with International Students";

                testDataArray[4][0] = "40000";
                testDataArray[4][1] = "Apr";
                testDataArray[4][2] = "25";
                testDataArray[4][3] = "19:30 - 20:30";
                testDataArray[4][4] = "Vancouver BC";
                testDataArray[4][5] = "Awesome Code";
                testDataArray[4][6] = "Every Code Awesome";
                break;
            default:
        }

        return testDataArray;
    }

    public static int postCount=0;
    public static String[][] postedUserEvent = new String[5][5];

    public boolean setPostedUserEvent(String eventName, String location,String date, String time, String description){
        if(postCount == 5){
            System.out.println("Overflow !");
            return false;
        }else{
            postedUserEvent[postCount][0] = eventName;
            postedUserEvent[postCount][1] = location;
            postedUserEvent[postCount][2] = date;
            postedUserEvent[postCount][3] = time;
            postedUserEvent[postCount][4] = description;
            postCount++;
            return true;
        }
    }

}

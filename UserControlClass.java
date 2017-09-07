package Itfes;

/**
 * Created by Nobuaki on 2017-04-19.
 */
public class UserControlClass {

    private EventControlClass ecc = new EventControlClass();

    public boolean newRegister(String name, String eMail,String password, String category){
        /** It'll change to DB **/
        String[][] userSampleData = this.getUserSampleData();

        for(int i=0; i<userSampleData.length;i++){
            if(userSampleData[i][1].equals(eMail)){
                System.out.println("This eMail already exists");
                return false;
            }
        }

        // 疑似DBに登録
        this.saveUserAccount(name, eMail, password, category);

        return true;
    }

    public boolean RenewAccount(String name, String eMail,String password, String category){
        /** It'll change to DB **/
        String[][] userSampleData = this.getUserSampleData();

        for(int i=0; i<userSampleData.length;i++){
            if(userSampleData[i][1].equals(eMail)){
                System.out.println("This eMail already exists");
                return false;
            }
        }

        if(this.getUserAccount()[1].equals(eMail)){
            System.out.println("This eMail already exists");
            return false;
        }

        // 疑似DBに登録
        this.saveUserAccount(name, eMail, password, category);

        return true;
    }

    public boolean login(String eMail,String password){

        String[][] userSampleData = this.getUserSampleData();

        for(int i=0; i<userSampleData.length;i++){
            if(userSampleData[i][1].equals(eMail) && userSampleData[i][2].equals(password)){
                this.saveUserAccount(userSampleData[i][0], userSampleData[i][1], userSampleData[i][2], userSampleData[i][3]);
                return true;
            }
        }

        System.out.println("This eMail is not found or this password does not match");
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

    public String[][] getUserSampleData(){
        String [][] testUserData = new String[3][4];
        /**
         * name, eMail, password, category
         */
        testUserData[0][0] = "Maddy";
        testUserData[0][1] = "abc@gmail.com";
        testUserData[0][2] = "test";
        testUserData[0][3] = "Web developer";

        testUserData[1][0] = "Kaori";
        testUserData[1][1] = "efg@nifty.com";
        testUserData[1][2] = "hogehoge";
        testUserData[1][3] = "Front End Engineer";

        testUserData[2][0] = "Nobubu";
        testUserData[2][1] = "hijk@mac.com";
        testUserData[2][2] = "brabrara";
        testUserData[2][3] = "Server Side Engineer";

        return testUserData;

    }


    public static String userName, userEmail, userPassword, userCategory;
    public static int[] userEventlist = new int[5];
    public static int count=0;

    public void saveUserAccount(String name, String eMail, String password, String category){
        userName = name;
        userEmail = eMail;
        userPassword = password;
        userCategory = category;
    }

    public String[] getUserAccount(){
        String[] userInformation = new String[4];
        userInformation[0] = userName;
        userInformation[1] = userEmail;
        userInformation[2] = userPassword;
        userInformation[3] = userCategory;

        return userInformation;
    }

    public boolean setUserEvent(int EventID){
        if(count == 5){
            System.out.println("Error setEvent overflow !");
            return false;
        }else{
            userEventlist[count] = EventID;
            count++;
            return true;
        }
    }

    /**
     * This function will have to change into DB process
     * Terrible code
     */
    public String[][] getUserEvent(){
        String[][] upcomingEventArray = this.ecc.makeTestData(0);
        String[][] recommendEventArray = this.ecc.makeTestData(1);
        String[][] resultUserEventList = new String[5][7];

        for(int i=0;i<userEventlist.length;i++){
            for(int j=0;j<upcomingEventArray.length;j++){
                if(userEventlist[i] == Integer.parseInt(upcomingEventArray[j][0])){
                    resultUserEventList[j][0] = upcomingEventArray[j][0];
                    resultUserEventList[j][1] = upcomingEventArray[j][1];
                    resultUserEventList[j][2] = upcomingEventArray[j][2];
                    resultUserEventList[j][3] = upcomingEventArray[j][3];
                    resultUserEventList[j][4] = upcomingEventArray[j][4];
                    resultUserEventList[j][5] = upcomingEventArray[j][5];
                    resultUserEventList[j][6] = upcomingEventArray[j][6];
                }

                if(j<3 && recommendEventArray[j][0] != null &&
                        userEventlist[i] == Integer.parseInt(recommendEventArray[j][0])){
                    resultUserEventList[j][0] = recommendEventArray[j][0];
                    resultUserEventList[j][1] = recommendEventArray[j][1];
                    resultUserEventList[j][2] = recommendEventArray[j][2];
                    resultUserEventList[j][3] = recommendEventArray[j][3];
                    resultUserEventList[j][4] = recommendEventArray[j][4];
                    resultUserEventList[j][5] = recommendEventArray[j][5];
                    resultUserEventList[j][6] = recommendEventArray[j][6];
                }
            }
        }
        return resultUserEventList;

    }

}

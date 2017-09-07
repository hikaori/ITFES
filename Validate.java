package Itfes;

/**
 * Created by kaorihirata on 2017-04-19.
 */
interface Validate {
    public boolean validate(String name, String email, String password, String category);
    public boolean validate(String eventName, String location, String date, String time, String description);
}

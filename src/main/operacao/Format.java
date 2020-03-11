package main.operacao;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Format {

	public static LocalDateTime formatter(String date, String time) throws ParseException{   
        String myDate = date + "  " + time;
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(myDate, formatter);
       
       
        return dateTime;
    }
}

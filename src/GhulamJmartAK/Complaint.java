package GhulamJmartAK;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable
{
    public Date date;
    public String desc;

    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }

    public boolean validate(){
        return false;
    }

    public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + "desc = '" + this.desc + "'}";
    }
}

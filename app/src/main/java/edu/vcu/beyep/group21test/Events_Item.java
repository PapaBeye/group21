package edu.vcu.beyep.group21test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class Events_Item {
    private String Ename;
    private LocalDateTime Date;
    private String Description;
    private String fee;


    public  Events_Item(String name, LocalDateTime D, String Des, String fee ){
        this.fee = fee;
        this.Ename = name;
        this.Date = D;
        this.Description = Des;
    }

    public void setEname(String N){
        this.Ename = N;
    }
    public void setDate(LocalDateTime D){
        this.Date = D;
    }
    public void setDescription(String Des){
        this.Description = Des;
    }
    public void setFee(String fee){
        this.fee = fee;
    }
    public String getEname(){
        return this.Ename;
    }
    public String getDescription(){
        return this.Description;
    }
    public String getFee(){
        return this.fee;
    }
    public LocalDateTime getDate(){
        return this.Date;
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author --Client-ServEr--
 */
public class Event {
    
    //Dinh nghia cac thuoc tinh
    private String EventID;
    private String EventName;
    private String Location;
    private Date TimeStart;
    private Date TimeEnd;
    private int NumOfPeople;
    private int Rating;
    
    //Dinh nghia phuong thuc khoi tao
    public Event(){}
    public Event(Event event)
    {
        this.EventID=event.EventID;
        this.EventName=event.EventName;
        this.Location=event.Location;
        this.TimeStart=event.TimeStart;
        this.TimeEnd=event.TimeEnd;
        this.NumOfPeople=event.NumOfPeople;
        this.Rating=event.Rating;
    }
    
    //Dinh nghia cac phuong thuc Get/Set
    public void SetEventID(String EventID)
    {
        this.EventID=EventID;
    }
    public String GetEventID()
    {
        return EventID;
    }
    public void SetEventName(String EventName)
    {
        this.EventName=EventName;
    }
    public String GetEventName()
    {
        return EventName;
    }
    public void SetLocation(String Location)
    {
        this.Location=Location;
    }
    public String GetLocation()
    {
        return Location;
    }
    public void SetTimeStart(Date TimeStart)
    {
        this.TimeStart=TimeStart;
    }
    public Date GetTimeStart()
    {
        return TimeStart;
    }
    public void SetTimeEnd(Date TimeEnd)
    {
        this.TimeEnd=TimeEnd;
    }
    public Date GetTimeEnd()
    {
        return TimeEnd;
    }
    public void SetNumOfPeople(int NumOfPeople)
    {
        this.NumOfPeople=NumOfPeople;
    }
    public int GetNumOfPeople()
    {
        return NumOfPeople;
    }
    public void SetRating(int Rating)
    {
        this.Rating=Rating;
    }
    public int GetRating()
    {
        return Rating;
    }
}

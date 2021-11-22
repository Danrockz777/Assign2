package com.example.assign2;

public class BookingModal {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String Name;
    private String Address;
    private String Phone;
    private String Note;
    private String Date;
    private String Time;
    private String Delivery;
    private String String2;
    private int id;

    // creating getter and setter methods
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }


    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String Delivery) {
        this.Delivery = Delivery;
    }

    public String getString2() {
        return String2;
    }

    public void setString2(String String2) {
        this.String2 = String2;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public BookingModal(String Name,
                        String Address,
                        String Phone,
                        String Note,
                        String Date,
                        String Time,
                        String Delivery,
                        String String2) {
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Date = Date;
        this.Time = Time;
        this.Note = Note;
        this.Delivery = Delivery;
        this.String2 = String2;
    }


}

package ru.dmi3ev.lab04.entity;

import java.util.Date;

public class Complete {

    public Complete(String subject, Date data_complete, int percent_compl, String type_work){
       this.subject =  subject;
        this.data_complete =  data_complete;
        this.percent_compl =  percent_compl;
        this.type_work =  type_work;

    }

    public Complete(){

    }

    private int id_c;
    private String subject;
    private Date data_complete;
    private int percent_compl;
    private String type_work;

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getData_complete() {
        return data_complete;
    }

    public void setData_complete(Date data_complete) {
        this.data_complete = data_complete;
    }

    public int getPercent_compl() {
        return percent_compl;
    }

    public void setPercent_compl(int percent_compl) {
        this.percent_compl = percent_compl;
    }

    public String getType_work() {
        return type_work;
    }

    public void setType_work(String type_work) {
        this.type_work = type_work;
    }
}

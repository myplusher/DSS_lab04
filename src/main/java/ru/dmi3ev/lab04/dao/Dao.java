package ru.dmi3ev.lab04.dao;

import ru.dmi3ev.lab04.entity.Complete;

import java.sql.Date;
import java.util.List;

public interface Dao {

    List<Complete> listAllWork();
    void addWork(Complete complete);
    void delWork(int id);
    void updWork(int id, Date data_complete, int percent);
}

package ru.dmi3ev.lab04.dao;

import ru.dmi3ev.lab04.entity.Complete;
import ru.dmi3ev.lab04.logic.Logic;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Logic implements Dao {

    Connection connection;


    public UserDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Complete> listAllWork() {
        System.out.println("**********");
        List<Complete> completeList = new ArrayList<>();
        String lineFormat = "%s. %s %s %s (%s)";
        String query = "select id_c, sub_name, `data_complete`, `percent_compl`, `type_work` from complete left join subjects on complete.subject = subjects.id_s  ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = this.connection.prepareStatement(query);
            rs = stmt.executeQuery();

            int rowNum = 0;
            while(rs.next()) {
                Complete complete = new Complete();
                complete.setId_c(rs.getInt("id_c"));
                complete.setSubject(rs.getString("subjects.sub_name"));
                complete.setData_complete(rs.getDate("data_complete"));
                complete.setPercent_compl(rs.getInt("percent_compl"));
                complete.setType_work(rs.getString("type_work"));
                completeList.add(complete);
            }
        } catch (SQLException sqle) {
            System.out.println("Произошла ошибка при выполнении SQL запроса:");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (Exception e) {
                // do nothing
            }
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
            } catch (Exception e) {
                // do nothing
            }
        }
        return completeList;
    }

    @Override
    public void addWork(Complete complete) {

        String query =
                "insert into complete (subject, type_work, percent_compl, data_complete)" +
                        " values (?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            stmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, complete.getSubject());
            stmt.setString(2, complete.getType_work());
            stmt.setInt(3, complete.getPercent_compl());
            stmt.setDate(4, new java.sql.Date(complete.getData_complete().getTime()));

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println("Работа успешно добавлена с ID = " + rs.getInt(1));
                }
            } else {
                System.out.println("Не удалось добавить работу.");
            }
        } catch (SQLException sqle) {
            System.out.println("Произошла ошибка при выполнении SQL запроса:");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (Exception e) {
                // do nothing
            }
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
            } catch (Exception e) {
                // do nothing
            }
        }

    }

    @Override
    public void delWork(int id) {
        System.out.println();
        String query = "delete from complete where `id_c` = " + id;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int rows = stmt.executeUpdate();
            System.out.printf("%d строк удалено: ", rows);
            System.out.println(query);
            if (rows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println("Работа успешно удалена");
                }
            } else {
                System.out.println("Не удалось удалить работу!");
            }
        } catch (SQLException sqle) {
            System.out.println("Произошла ошибка при выполнении SQL запроса:");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (Exception e) {
// do nothing
            }
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
            } catch (Exception e) {
// do nothing
            }
        }
    }

    @Override
    public void updWork(int id, Date data_complete, int percent) {
        System.out.println();
        Complete complete = new Complete();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        System.out.println(data_complete.getTime());
        String query = "UPDATE complete SET data_complete = '" + new java.sql.Date(data_complete.getTime()) + "', percent_compl = " + percent + " where id_c = " + id;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            int rows = stmt.executeUpdate();
            System.out.printf("%d строк обновлено: ", rows);
            System.out.println(query);
            if (rows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println("Работа успешно обновлена");
                }
            } else {
                System.out.println("Не удалось обновить работу!");
            }
        } catch (SQLException sqle) {
            System.out.println("Произошла ошибка при выполнении SQL запроса:");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (Exception e) {
// do nothing
            }
            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
            } catch (Exception e) {
// do nothing
            }
        }
    }
}

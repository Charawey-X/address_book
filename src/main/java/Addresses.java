import org.sql2o.*;

import java.util.List;

public class Addresses implements DAO {

    private final Sql2o sql2o;

    public Addresses(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere, so we can call methods in it
    }

    @Override
    public void add(Entry entry) {
        String sql = "INSERT INTO address_table (\"name\") VALUES (':name')"; //raw sql
        try(Connection con = sql2o.open()){ //try to open a connection
            String name =(String) con.createQuery(sql, true) //make a new variable
                    .bind(entry) //map my argument onto the query, so we can use information from it
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            entry.setName(name); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println("Error"); //oops, we have an error!
        }
    }

    @Override
    public List<Entry> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM address_table") //raw sql
                    .executeAndFetch(Entry.class); //fetch a list
        }
    }

    @Override
    public Entry findByName(String name) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM address_book WHERE name = :name")
                    .addParameter("name", name) //key/value pair, key must match above
                    .executeAndFetchFirst(Entry.class); //fetch an individual item
        }
    }

    @Override
    public void update(String name, String email_address){
        String sql = "UPDATE address_book SET email_address = :email_address WHERE name=:name";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("email_address", email_address)
                    .addParameter("name", name)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println("Error");
        }
    }

    @Override
    public void deleteByName(String name) {
        String sql = "DELETE from address_book WHERE name=:name";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Error");
        }
    }

    @Override
    public void clearAllTasks() {
        String sql = "DELETE from address_book";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Error");
        }
    }

}

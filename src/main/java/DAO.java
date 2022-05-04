import java.util.List;

public interface DAO {
    // LIST
    List<Entry> getAll();

    // CREATE
    void add(Entry entry);

    // READ
    Entry findByName(String name);

    // UPDATE
    void update(String name, String email_address);

    // DELETE
    void deleteByName(String name);
    void clearAllTasks();
}

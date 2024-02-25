package user;

import sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Alejandro Ramirez Macias
 */
public class User {
    public int id;
    public String name;
    public String pass;
    
    // constructor
    public User(int id, String name, String pass){
        this.id = id;
        this.name = name;
        this.pass = pass;
    }
    
    // toString override
    @Override
    public String toString() {
        return String.format("User: {id: %d, name: %s, pass: %s}", 
                this.id, 
                this.name, 
                this.pass);
    }
    
    public static boolean isExistsTable() {
        final String SQL = "SELECT 1 FROM users LIMIT 1";
        Object res = SQLiteConnection.executeSqlScalar(SQL);
        return res != null;
    }
    
    public static int getIdFromNameAndPass(String name, String pass) {
        int id = -1;
        final String SQL = "SELECT id FROM users WHERE name = ? AND pass = ?";
        Object res = SQLiteConnection.executeSqlScalar(SQL, new Object[]{name, pass});
        if (res != null)
            id = (int) res;
        return id;
    } 
    
    public static boolean isExists(String name, int id) {
        final String SQL = "SELECT 1 FROM users WHERE name = ? AND id <> ?";
        Object res = SQLiteConnection.executeSqlScalar(SQL, new Object[]{name, id});
        return res != null;
    }
    
    private static User _getFromMap(Map<String, Object> map) {
        return new User(
            (int) map.get("id"),
            (String) map.get("name"),
            (String) map.get("pass")
        );
    }
    
    public static User get(int id) {
        final String SQL = "SELECT id, name, pass FROM users WHERE id = ?";
        var row = SQLiteConnection.executeSqlQueryRow(SQL, new Object[]{id});
        return _getFromMap(row);
    }
    
    public static ArrayList<User> getAll() {
        var users = new ArrayList<User>(){}; // empty
        final String SQL = "SELECT id, name, pass FROM users ORDER BY name";
        var rows = SQLiteConnection.executeSqlQuery(SQL);
        for (Map<String, Object> row : rows) {
            var user = _getFromMap(row);
            users.add(user);
        }
        return users;
    }
    
    public static int insert(User user) {
        int id = -1;
        final String SQL = "INSERT INTO users (name, pass) "
                         + "VALUES (?, ?) "
                         + "RETURNING id";       
        Object res = SQLiteConnection.executeSqlScalar(SQL, new Object[]{
            user.name,
            user.pass
        });
        if (res != null)
            id = (int) res;
        return id;
    }
    
    public static void updatePass(String pass, int id) {
        final String SQL = "UPDATE users SET "
                           + "pass = ? "
                         + "WHERE id = ?";
        SQLiteConnection.executeSql(SQL, new Object[]{pass, id});
    }
    
    public static void update(User user) {
        final String SQL = "UPDATE users SET "
                           + "name = ? "                
                         + "WHERE id = ?";
        SQLiteConnection.executeSql(SQL, new Object[]{
            user.name,            
            user.id
        });
        
        // update pass?
        if (!user.pass.isEmpty())
            updatePass(user.pass, user.id);
    }
    
    public static void delete(int id) {
        final String SQL = "DELETE FROM users WHERE id = ?";
        SQLiteConnection.executeSql(SQL, new Object[]{id});
    }
}

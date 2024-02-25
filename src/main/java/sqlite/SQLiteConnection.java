package sqlite;

import main.Message;
import user.User;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alejandro Ramirez Macias
 */
public class SQLiteConnection {

    private static String _path = "";
    private static Connection _conn = null;
    
    public static boolean isExistsConnection(String path) {
        _path = path;
        //Class.forName("org.sqlite.JDBC");
        SQLiteConnection._open();
        
        if (_conn != null) {
            // read table users if exists
            boolean isExists = User.isExistsTable(); // close after read table
            if (!isExists) {
                _conn = null;

                // delete new database empty
                File file = new File(path);
                file.delete();
            }
        }        
        return _conn != null;
    }

    private static void _open() {
        String url = "jdbc:sqlite:" + _path;
        System.out.println(url);
        try {
            _conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            _conn = null;
        }
    }

    public static void executeSql(String sql) {
        executeSql(sql, null);
    }

    public static void executeSql(String sql, Object[] params) {
        SQLiteConnection._open();
        try {
            var ps = _conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            ps.execute();
            _conn.close();
        } catch (SQLException e) {
            Message.showError("[DB] Error\n" + e.getMessage());
        }
    }

    /**
     *
     * @param sql : statement
     * @return Object : one value scalar
     */
    public static Object executeSqlScalar(String sql) {
        return executeSqlScalar(sql, new Object[0]);
    }

    public static Object executeSqlScalar(String sql, Object[] params) {
        // null is error
        Object res = null;
        SQLiteConnection._open();
        try {
            var ps = _conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getObject(1); // start index 1 (zero not exists on DB)
            }
            _conn.close();
        } catch (SQLException e) {
            Message.showError("[DB] Error\n" + e.getMessage());
        }
        return res;
    }

    public static Map<String, Object> executeSqlQueryRow(String sql, Object[] params) {
        // empty is error
        var map = new HashMap<String, Object>(); // empty
        SQLiteConnection._open();
        try {
            var ps = _conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            var rsmd = rs.getMetaData();
            if (rs.next()) {
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String colName = rsmd.getColumnName(i + 1); // 1 first index  
                    Object value = rs.getObject(i + 1);
                    map.put(colName, value);
                }
            }
            _conn.close();
        } catch (SQLException e) {
            Message.showError("[DB] Error\n" + e.getMessage());
        }
        return map;
    }

    // without params
    public static List<Map<String, Object>> executeSqlQuery(String sql) {
        return executeSqlQuery(sql, null);
    }

    public static List<Map<String, Object>> executeSqlQuery(String sql, Object[] params) {
        List<Map<String, Object>> listMap = new ArrayList<>(); // empty
        SQLiteConnection._open();
        try {
            var ps = _conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            var rsmd = rs.getMetaData();
            while (rs.next()) {
                // new map
                var map = new HashMap<String, Object>(); // empty

                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String colName = rsmd.getColumnName(i + 1); // 1 first index  
                    Object value = rs.getObject(i + 1);
                    map.put(colName, value);
                }

                // add to list
                listMap.add(map);
            }
            _conn.close();
        } catch (SQLException e) {
            Message.showError("[DB] Error\n" + e.getMessage());
        }
        return listMap;
    }
}

import java.sql.*;

public class Search {
    public void searchFlats(Connection conn, String parameter, String value) throws SQLException {
        String sqlRequest = null;

        sqlRequest = "SELECT * FROM Flats WHERE " + parameter +" LIKE " + "'%" + value + "%'";
        PreparedStatement ps = conn.prepareStatement(sqlRequest);
        try {
            // table of data representing a database result set,
            ResultSet rs = ps.executeQuery();
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + " \t\t ");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + " \t\t ");
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }

    }
}

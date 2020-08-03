package com.sandeep.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class LearningDbUtils
{
    /*
     * Step 1 : Download Driver Step 2: Load Driver into Memory Step 3: Create the connection Step 4:Create a statement
     * Fire the query and get the result set get the result Close the connection
     */

    static Connection connection;

    static Statement statement;

    static String sql = "select * from Persons;";

    // select FirstName from Persons where City like '%Ambala%';
    static ResultSet result;

    static ResultSetMetaData data;

    public static void main(String[] args) throws SQLException
    {

        try {

            // Step 2: Load Driver into Memory Step
            Class.forName("com.mysql.jdbc.Driver");

            // Step 3 Create a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeportal", "root", "root");

            // Step 4 Create a statement/Object which will execute the query
            statement = connection.createStatement();

            // Step 5 execute the sql using executeQuery Method, for select query we use this and
            // for delete update and insert we use executeUdpdate method
            // statement.executeUpdate(sql);
            result = statement.executeQuery(sql);
            // The cursor of the Result Set by Default is on zero row which needs to moved to 1st Row and hence
            // we use next() method

            while (result.next()) {

                // Extract the values of rows using while loop and String format
                System.out.println(String.format(" %s : %s : %s : %s : %s ", result.getString(1), result.getString(2),
                    result.getString(3), result.getString(4), result.getString(5)));

                /*
                 * Step 6 To extract more info regarding the number of columns in table and column name, we use another
                 * method getmetadata to capture info and pass to ResultSetMetadata Interface object data
                 */
                data = result.getMetaData();
                String[] columnName = new String[data.getColumnCount()];

                for (int i = 1; i <= data.getColumnCount(); i++) {
                    // System.out.println(data.getColumnName(i));
                    columnName[i - 1] = data.getColumnName(i);
                    System.out.println(columnName[i - 1]);
                }

                // System.out.println(columnName.toString());

            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();

        }

    }

}

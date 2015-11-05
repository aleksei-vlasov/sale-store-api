import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex Vlasov on 02.11.15.
 */
public class testConnection {

        public static void main(String[] args)
        {
            Connection connection = null;
            try
            {
                // the postgresql driver string
                Class.forName("org.postgresql.Driver");

                // the postgresql url
                String url = "jdbc:postgresql://localhost:5432/salestoreapi";

                // get the postgresql database connection
                connection = DriverManager.getConnection(url, "postgres", "admin");

                // now do whatever you want to do with the connection
                // ...

            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                System.exit(2);
            }
        }

}

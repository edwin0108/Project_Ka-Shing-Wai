import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries
{
   private static final String URL = "jdbc:derby:addressbook";
   private static final String USERNAME = "deitel";
   private static final String PASSWORD = "deitel";

   private Connection connection; // manages connection
   private PreparedStatement selectAllPeople;
   private PreparedStatement selectPeopleByState;
   private PreparedStatement insertNewPerson;
   private PreparedStatement updateCurrentPerson;
   private PreparedStatement deleteCurrentPerson;

   // constructor
   public PersonQueries()
   {
      try{
         Class.forName("org.apache.derby.jdbc.ClientDriver");
      }catch (ClassNotFoundException e){
         e.printStackTrace();
      }
      try
      {
         connection =
                 DriverManager.getConnection(URL, USERNAME, PASSWORD);

         // create query that selects all entries in the AddressBook
         selectAllPeople =
                 connection.prepareStatement("SELECT * FROM Addresses");

         // create query that selects entries with a specific state
         selectPeopleByState = connection.prepareStatement(
                 "SELECT * FROM Addresses WHERE USState = ?");

         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement(
                 "INSERT INTO Addresses " +
                         "(FirstName, LastName, Email, PhoneNumber, USState) " +
                         "VALUES (?, ?, ?, ?, ?)");

         // delete current entry from the database
         deleteCurrentPerson = connection.prepareStatement(
                 "DELETE FROM Addresses WHERE AddressID = ? ");

         //update current entry from the database
         updateCurrentPerson = connection.prepareStatement(
                 "UPDATE Addresses SET FirstName = ?, LastName = ?, Email = ?, PhoneNumber = ?, USState = ? " +
                         "WHERE AddressID = ?");

      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         System.exit(1);
      }
   } // end PersonQueries constructor

   // select all of the addresses in the database
   public List< Person > getAllPeople()
   {
      List< Person > results = null;
      ResultSet resultSet = null;

      try
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllPeople.executeQuery();
         results = new ArrayList< Person >();

         while (resultSet.next())
         {
            results.add(new Person(
                    resultSet.getInt("addressID"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("USState")));
         }
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      }
      finally
      {
         try
         {
            resultSet.close();
         }
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();
            close();
         }
      }
      return results;
   }

   // select person by state
   public List<Person> getPeopleByState(String state){
      List<Person> results = null;
      ResultSet resultSet = null;

      try {
         selectPeopleByState.setString(1,state);
         resultSet = selectPeopleByState.executeQuery();
         results = new ArrayList<Person>();

         while (resultSet.next()){
            results.add(new Person(resultSet.getInt("addressID"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("USState")));
         }
      }
      catch (SQLException ex){
         ex.printStackTrace();
      }
      finally {
         try {
            resultSet.close();
         }
         catch (SQLException ex){
            ex.printStackTrace();
            close();
         }
      }
      return results;
   }

   // add an entry
   public int addPerson(
           String fname, String lname, String email, String num, String state)
   {
      int result = 0;

      // set parameters, then execute insertNewPerson
      try
      {
         insertNewPerson.setString(1, fname);
         insertNewPerson.setString(2, lname);
         insertNewPerson.setString(3, email);
         insertNewPerson.setString(4, num);
         insertNewPerson.setString(5, state);

         // insert the new entry; returns # of rows updated
         result = insertNewPerson.executeUpdate();
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         close();
      }

      return result;
   }

   public int deletePerson(int addressID){
      int result = 0;
      try {
         deleteCurrentPerson.setInt(1,addressID);
         result = deleteCurrentPerson.executeUpdate();
      }catch (SQLException s){
         s.printStackTrace();
         close();
      }
      return result;
   }

   public int updatePerson(int addressID, String fname, String lname, String email, String num, String state){
      int result = 0;
      try {
          updateCurrentPerson.setString(1, fname);
          updateCurrentPerson.setString(2, lname);
          updateCurrentPerson.setString(3, email);
          updateCurrentPerson.setString(4, num);
          updateCurrentPerson.setString(5, state);
          updateCurrentPerson.setInt(6,addressID);

         result = updateCurrentPerson.executeUpdate();
      }catch (SQLException s){
         s.printStackTrace();
         close();
      }
      return result;
   }

   // close the database connection
   public void close()
   {
      try
      {
         connection.close();
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      }
   }

} // end class PersonQueries


 
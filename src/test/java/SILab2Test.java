import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {


    private List<String> allUsers = null;
    private final SILab2 siLab2 = new SILab2();
    private  User user = null;


    @Test
    void everyBranchTest(){
        // Test when user = null and throws exception.
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,()->siLab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        //Test when user.getUsername() = null and throws exception.
        user = new User(null, "Password!1","email@example.com");
        ex = assertThrows(RuntimeException.class,()->siLab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        //Test when user.getUsername()="Username",user.getPassword()="passwordUsername" and returns false.
        user = new User("Username", "passwordUsername","email@example.com");
        assertFalse(()->siLab2.function(user,allUsers));

        //Test when user.getUsername()="Username",user.getPassword()="passwor" and returtns false
        user = new User("Username", "passwor","email@example.com");
        assertFalse(()->siLab2.function(user,allUsers));

        //Test when user.getUsername()="Username" ,user.getPassword()="Password!1" and returns true
        user = new User("Username", "Password!1","email@example.com");
        assertTrue(()->siLab2.function(user,allUsers));

        //Test when user.getUsername()="Username" ,user.getPassword()="password" and returns false
        user = new User("Username", "password","email@example.com");
        assertFalse(()->siLab2.function(user,allUsers));

    }

    @Test
    void multipleConditionTest(){
        RuntimeException ex;
        //if (user.getUsername()==null || user.getPassword()==null)
        // T||X user.getUsername()=null
        user = new User(null, "Password!1","email@example.com");
        ex = assertThrows(RuntimeException.class,()->siLab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        // F||T user.getUsername()="Username", user.getPassword()=null
        user = new User("Username", null,"email@example.com");
        ex = assertThrows(RuntimeException.class,()->siLab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        // F||F user.getUsername()="Username", user.getPassword()="Password1!"
        user = new User("Username", "Password!1","email@example.com");
        assertTrue(()->siLab2.function(user,allUsers));

        //if (!digit || !upper || !special)

        // T||X||X user.getUsername()="Username", user.getPassword()="passworD!"
        user = new User("Username", "passworD!","email@example.com");
        assertFalse(()->siLab2.function(user,allUsers));

        // F||T||X user.getUsername()="Username", user.getPassword()="password1!"
        user = new User("Username", "password1!","email@example.com");
        assertFalse(()->siLab2.function(user,allUsers));

        // F||F||T user.getUsername()="Username", user.getPassword()="passworD1"
        user = new User("Username", "passworD1","email@example.com");
        assertFalse(()->siLab2.function(user,allUsers));

        // F||F||F user.getUsername()="Username", user.getPassword()="passworD1!"
        user = new User("Username", "passworD1!","email@example.com");
        assertTrue(()->siLab2.function(user,allUsers));

    }


}
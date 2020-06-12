import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {                            //1

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";

        if (user==null) {

            throw new RuntimeException("The user is not instantiated");                     //2
        }

        if (user.getUsername()==null || user.getPassword()==null) {                         //3
            throw new RuntimeException("The user is missing some mandatory information");   //4

        }

        String password = user.getPassword();                                               //5
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase())) {
            return false;                                                                   //6
        }
        else if (passwordLower.length()<8) {                                                //7
            return false;                                                                   //8
        }
        else {                                                                              //9
            boolean digit = false, upper = false, special = false;                          //10

            for (int i=0;i<password.length();i++) {                                         //11
                if (Character.isDigit(password.charAt(i)))                                  //12
                    digit = true;                                                           //13
                if (Character.isUpperCase(password.charAt(i)))                              //14
                    upper = true;                                                           //15
                if (specialCharacters.contains(String.valueOf(password.charAt(i))))         //16
                    special = true;                                                         //17
            }

            if (!digit || !upper || !special) {                                             //18
                return false;                                                               //19
            }
        }
        return true;                                                                        //20
    }                                                                                       //21
}

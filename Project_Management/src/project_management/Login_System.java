
package project_management;


public class Login_System {
    private final static String User = "lexuanhung@gmail.com";
    private final static String Pass_word = "1234";
    public static boolean isLogin(String user,String password){
        return User.equals(user)&&Pass_word.equals(password);
        
    }
}

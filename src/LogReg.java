import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogReg")
public class LogReg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       final String accessGranted="access granted";
       final String accessDenied="access Denied";
       final int userAdded=200;
       final int userNotadded=201;
       UserPool userPool=new UserPool();
       User user=new User("11","11");
       userPool.addUser(user);


        String action = request.getParameter("action");
        System.out.println("debug: action: "+action);
        String username = request.getParameter("username");
        System.out.println("debug: username: "+username);
        String password = request.getParameter("password");
        System.out.println("debug: password "+password);
        user=new User(username,password);


        if (action.equals(new String("login"))){
            if(userPool.checkUser(user)){
                response.getWriter().write(accessGranted);
            }
            else {
                response.getWriter().write(accessDenied);}
        }
        else if(action.equals(new String("register"))){
            if (!userPool.checkUser(user)){
                userPool.addUser(user);
                System.out.println("debug: user is added to the pool");
                response.getWriter().write("user created");
            }
            else{
                System.out.println("debug : user did not added to the pool");
                response.getWriter().write("user already taken");

            }
        }
    }
}

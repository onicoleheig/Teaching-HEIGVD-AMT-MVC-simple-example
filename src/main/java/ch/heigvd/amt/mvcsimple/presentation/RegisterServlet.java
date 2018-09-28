package ch.heigvd.amt.mvcsimple.presentation;

import ch.heigvd.amt.mvcsimple.business.RegisterForm;
import ch.heigvd.amt.mvcsimple.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

/**
 * The QuoteServlet is the Controller in the pattern. It receives HTTP requests, decides that the
 * QuoteGenerator service can provide the model (a list of Quote objects). After invoking the
 * service and obtaining the model, it attaches the model to the request (as a parameter named 'quotes').
 * Finally, it finds the view capable of rendering the model (view.jsp) and delegates the end of the work
 * to this component (by calling forwarding the request).
 */
public class RegisterServlet extends javax.servlet.http.HttpServlet {

    private RegisterForm form; // we will see later how to replace this with dependency injection

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        form = new RegisterForm();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        registerForm(request, response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        User user = form.register(request);
        request.setAttribute("user", user);
        if (!form.getErreurs().isEmpty()) {
            for (Map.Entry<String, String> error : form.getErreurs().entrySet()) {
                System.out.println("error_" + error.getKey());
                request.setAttribute("error_" + error.getKey(), error.getValue());
            }
        }
        registerForm(request, response);
    }

    protected void registerForm(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
}

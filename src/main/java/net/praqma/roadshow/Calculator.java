package net.praqma.roadshow;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.praqma.roadshow.model.CalculatorModel;
import net.praqma.roadshow.model.CalculatorModelImpl;

/**
 * Servlet implementation class Calculator
 */
@WebServlet(urlPatterns = {"/Calculator"}, description = "This is a small Calculator App used for our roadshow", displayName = "Calulator Demo", name = "Calculator")
public class Calculator extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final CalculatorModel model = new CalculatorModelImpl();
    double result;

    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valueString = request.getParameter("value");
        String resultString = request.getParameter("result");

        double result = 0;
        if (resultString != null && !resultString.isEmpty()) {
            result = Double.parseDouble(resultString);
        }

        if (valueString != null && !valueString.isEmpty()) {
            if (valueString != null) {
                double value = Double.parseDouble(valueString);

                Map parameters = request.getParameterMap();
                if (parameters.containsKey("plus")) {
                    result = model.add(result, value).doubleValue();
                } else if (parameters.containsKey("minus")) {
                    result = model.subtract(result, value).doubleValue();
                } else if (parameters.containsKey("divide")) {
                    result = model.divide(result, value).doubleValue();
                } else if (parameters.containsKey("multiply")) {
                    result = model.multiply(result, value).doubleValue();
                }

                request.setAttribute("value", result);

                RequestDispatcher view = request.getRequestDispatcher("/Calc.jsp");
                view.forward(request, response);
            }
        } else {

            RequestDispatcher view = request.getRequestDispatcher("/Calc.jsp");
            view.forward(request, response);

        }
    }
}

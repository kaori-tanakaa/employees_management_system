package controllers.employees;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Belongs_num;
import models.Employee;
import models.Password;
import models.Report;
import utils.DBUtil;



/**
 * Servlet implementation class EmployeesNewServlet
 */
@WebServlet("/employees/new")
public class EmployeesNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();


        List<Belongs_num> belongsnum = em.createNamedQuery("getAllBelongsNum", Belongs_num.class).getResultList();

        em.close();

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("employee", new Employee());
        request.setAttribute("password", new Password());
        request.setAttribute("report", new Report());
        request.setAttribute("belongs_num", new Belongs_num());
        request.setAttribute("belongsnum", belongsnum);



        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new.jsp");
        rd.forward(request, response);
    }

}

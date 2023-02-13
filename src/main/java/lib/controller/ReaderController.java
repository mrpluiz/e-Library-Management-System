package lib.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lib.bo.Reader_BO;
import lib.dao.Lib_DAO;

/**
 * Servlet implementation class ReaderController
 */
@WebServlet("/ReaderController")
public class ReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String degree = request.getParameter("degree");
		String phone = request.getParameter("phone");
		String doi = request.getParameter("doi");
		String dor = request.getParameter("dor");
		String bookname = request.getParameter("bookname");

		Reader_BO rr = new Reader_BO(name, degree, phone, doi, dor, bookname);

		int status = Lib_DAO.addreader(rr);
		if(status>0) {
			RequestDispatcher rd = request.getRequestDispatcher("AllReaderController");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.htnl");
			rd.include(request, response);
		}
	}
}
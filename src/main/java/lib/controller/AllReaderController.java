package lib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lib.bo.Reader_BO;
import lib.dao.Lib_DAO;

/**
 * Servlet implementation class AllReaderController
 */
@WebServlet("/AllReaderController")
public class AllReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllReaderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<style>");
		pw.print("body {background-image: url('Images/BG_ContactForm.jpg');background-repeat: no-repeat;background-size: 100%;}");
		pw.print("table{border-collapse: collapse;width: 100%;}");
		pw.print("th{font-size: 20px;}");
		pw.print("th,td{text-align: center;padding: 20px;}");
		pw.print("tr:nth-child(even){background-color: #FFCE44;}");
		pw.print(".divsubmit {width: 50%;margin: 0px 10px;padding: 10px 20px;font-size: 20px Trebuchet MS;font-weight: bolder;color: whitesmoke;background-color: maroon;margin-top: 20px;text-align: center;text-decoration: none}");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<a href='home.html' class='divsubmit'>BACK</a>");

		pw.print("<table style='font-family: Trebuchet MS'>");
		pw.print("<tr><th>ID</th> <th>Name</th> <th>Degree</th> <th>Phone</th> <th>Date of Issue</th> <th>Date of Return</th> <th>Book Name</th> <th colspan=2>Actions</th> </tr>");

		List<Reader_BO> li = Lib_DAO.allreader();

		for(Reader_BO rr:li) {
			pw.print("<tr><td>" + rr.getId() + "</td><td>" + rr.getName() + "</td><td>" + rr.getDegree() + "</td><td>" + rr.getPhone() + "</td><td>" + rr.getDoi() + "</td><td>" + rr.getDor() + "</td><td>" + rr.getBookname() + "</td><td><a class='divsubmit' href='EditServlet?id=" + rr.getId() +"'>EDIT RECORD</a></td><td><a class='divsubmit' href='DeleteController?id="+rr.getId()+"'>DELETE RECORD</a></td></tr>");
		}
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");
	}
}
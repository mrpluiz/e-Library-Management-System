package lib.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.bo.Reader_BO;
import lib.dao.Lib_DAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		Reader_BO rr = Lib_DAO.getreaderbyID(id);

		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<meta charset='ISO-8859-1'>");
		pw.print("<title>e-Library Management System</title>");
		pw.print("<style>");
		pw.print("body {background-image: url('Images/BG_ContactForm.jpg');background-repeat: no-repeat;background-size: 100%;}");
		pw.print("h2 {text-align: center;font-family: 'Trebuchet MS';font-size: 180%;color: maroon;}");
		pw.print(".divi {background-color: whitesmoke;width: 500px;border: 2px solid maroon;padding: 20px;font-family: 'Trebuchet MS';font-size: 18px;margin: auto;outline: thick solid aliceblue;}");
		pw.print("input {border: 2.5px solid gray;padding: 10px;font-size: 18px;}");
		pw.print(".div30 {float: left;width: 200px;margin-top: 15px;}");
		pw.print(".div60 {float: left;width: 300px;margin-top: 15px;}");
        pw.print(".divsubmit {width: 50%;margin: 0 10px;padding: 10px 20px;font-size: 20px;font-weight: bolder;color: whitesmoke;background-color: maroon;margin-top: 20px;text-align: center;opacity: 0.6;transition: 0.3s;text-decoration: none;}");
        pw.print(".divsubmit:hover{opacity: 1;}");
        pw.print(".row:after {content: \"\";display: table;clear: both;}");
        pw.print(".flex {display: flex;}");
        pw.print("</style>");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<form action='UpdateController' method='get'>");
        pw.print("<div class='divi'>");
        pw.print("<h2>Update Reader Details</h2>");
        pw.print("<div class='row'><div class='div30'><label></label></div><div class=\"div60\"><input type='hidden' name ='id' value='"+rr.getId()+"'/></div></div>");
        pw.print("<div class='row'><div class='div30'><label>Name:</label></div><div class='div60'><input type='text' name ='name' value='"+rr.getName()+"'/></div></div>");
        pw.print("<div class='row'><div class='div30'><label>Degree:</label></div><div class='div60'><input type='text' name ='degree' value='"+rr.getDegree()+"'/></div></div>");
        pw.print("<div class='row'><div class='div30'><label>Phone:</label></div><div class='div60'><input type='text' name ='phone' value='"+rr.getPhone()+"'/></div></div>");
        pw.print("<div class='row'><div class='div30'><label>Date of Issue:</label></div><div class='div60'><input type='date' name ='doi' value='"+rr.getDoi()+"'/></div></div>");
        pw.print("<div class='row'><div class='div30'><label>Date of Return:</label></div><div class='div60'><input type='date' name ='dor' value='"+rr.getDor()+"'/></div></div>");
        pw.print("<div class='row'><div class='div30'><label>Bookname:</label></div><div class='div60'><input type='text' name ='bookname' value='"+rr.getBookname()+"'/></div></div>");
        pw.print("<div style='display: flex; justify-content: center'><input type='submit' value='Update' class='divsubmit'></div></div>");
        pw.print("</form>");
        pw.print("</body>");
        pw.print("</html>");
	}
}
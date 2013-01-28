package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser;
import fr.cpe.ha.jbbflight.models.User;

/**
 * Users' Controller
 * @author Julien Rouvier
 */
@SuppressWarnings("serial")
public class UserController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		// Get the action and redirect to the correct action
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.newUser(req, resp);
		}else if("view".equals(action)){
			this.viewUser(req, resp);
		}else if("edit".equals(action)){
			this.editUser(req, resp);
		}else if("list".equals(action)){
			this.listUser(req, resp);
		}else if("login".equals(action)){
			this.loginUser(req, resp);
		}
	}
	
	private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userlogin.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		// Get the action and redirect to the correct action
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.createUser(req, resp);
		}else if("edit".equals(action)){
			this.updateUser(req, resp);
		}
	}

	/**
	 * Diplay the new User Form view.
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void newUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/usernew.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Display the details user view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void viewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userview.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Display the user edit form view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/useredit.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Display the list users view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void listUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userlist.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function used to update the user passed in params in the datastore.
	 * 
	 * @param req
	 * @param resp
	 */
	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function used to add the user passed in params in the datastore.
	 * 
	 * @param req
	 * @param resp
	 */
	private void createUser(HttpServletRequest req, HttpServletResponse resp) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthdate = null;
		try {
			birthdate = sdf.parse(req.getParameter("usr_birthdate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User usr = new User();
		usr.setUsr_birthdate(birthdate);
		usr.setUsr_email(req.getParameter("usr_email"));
		usr.setUsr_firstname(req.getParameter("usr_firstname"));
		usr.setUsr_lastname(req.getParameter("usr_lastname"));
		usr.setUsr_login(req.getParameter("usr_login"));
		usr.setUsr_password(req.getParameter("usr_password"));
		
		DALUser dalUser = DALUser.getInstance();
		dalUser.AddUser(usr);
	}
}
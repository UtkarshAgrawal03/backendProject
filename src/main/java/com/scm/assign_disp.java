package com.scm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Servlet implementation class assign_disp
 */
@WebServlet("/assign_disp")
public class assign_disp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assign_disp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Assigned_table ob=new Assigned_table();
		
		PrintWriter out=response.getWriter();
			Configuration con=new Configuration().configure().addAnnotatedClass(sub_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class).addAnnotatedClass(Assigned_table.class);
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf=con.buildSessionFactory(reg);
			Session s1=sf.openSession();
			Transaction tx=s1.beginTransaction();
			ob=(Assigned_table)s1.get(Assigned_table.class,Integer.parseInt(request.getParameter("sid")));
			if(ob!=null) {
			out.println("Serial Id: "+ob.getSid()+"\n");
			out.println("Class Id: "+ob.getcId()+"\n");
			out.println("Sub Id: "+ob.getSubId()+"\n");
			out.println("Teacher ID: "+ob.getTid()+"\n");}
			else {
				response.sendRedirect("Assign_disp.jsp");
			}
			tx.commit();
			response.sendRedirect("AssignAdd.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

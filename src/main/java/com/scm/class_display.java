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
 * Servlet implementation class class_display
 */
@WebServlet("/class_display")
public class class_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class_display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		class_table ob=new class_table();
		Configuration con=new Configuration().configure().addAnnotatedClass(stud_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class);
				ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
				SessionFactory sf=con.buildSessionFactory(reg);
				Session s1=sf.openSession();
				Transaction tx=s1.beginTransaction();
				ob=(class_table)s1.get(class_table.class,Integer.parseInt(request.getParameter("did")));
				tx.commit();
				if(ob!=null) {
				PrintWriter out=response.getWriter();
				out.println("Class Standard: "+ob.getStd()+"\n");
				out.println("Class Strength: "+ob.getStrength()+"\n");
				out.println("Class teacher: "+ob.getClass_teacher()+"\n");}
				else{
					response.sendRedirect("class_disp.jsp");}
				}
				

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class sub_display
 */
@WebServlet("/sub_display")
public class sub_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sub_display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sub_table ob=new sub_table();
		Configuration con=new Configuration().configure().addAnnotatedClass(stud_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class);
				ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
				SessionFactory sf=con.buildSessionFactory(reg);
				Session s1=sf.openSession();
				Transaction tx=s1.beginTransaction();
				ob=(sub_table)s1.get(sub_table.class,Integer.parseInt(request.getParameter("did")));
				tx.commit();
				PrintWriter out=response.getWriter();
				out.println("Teacher id: "+ob.getSub_id()+"\n");
				out.println("Teacher name: "+ob.getSub_name()+"\n");
				
				}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

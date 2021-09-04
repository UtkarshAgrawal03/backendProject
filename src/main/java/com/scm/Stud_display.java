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
 * Servlet implementation class Stud_display
 */
@WebServlet("/Stud_display")
public class Stud_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stud_display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stud_table ob=new stud_table();
	Configuration con=new Configuration().configure().addAnnotatedClass(stud_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class);
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf=con.buildSessionFactory(reg);
			Session s1=sf.openSession();
			Transaction tx=s1.beginTransaction();
			ob=(stud_table)s1.get(stud_table.class,Integer.parseInt(request.getParameter("did")));
			tx.commit();
			PrintWriter out=response.getWriter();
			out.println("student id: "+ob.getStu_id()+"\n");
			out.println("student name: "+ob.getStu_name()+"\n");
			out.println("student Address: "+ob.getStu_Address()+"\n");
			out.println("student Contact: "+ob.getStu_contact()+"\n");
			out.println("student gender: "+ob.getStu_gen()+"\n");
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

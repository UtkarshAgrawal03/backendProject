package com.scm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Servlet implementation class Stud_dispcom
 */
@WebServlet("/Stud_dispcom")
public class Stud_dispcom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stud_dispcom() {
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
				Query q=s1.createQuery("from stud_table");
				
				List<stud_table> al=q.list();
				for(stud_table a:al)
				{
				
				PrintWriter out=response.getWriter();
				out.println("student id: "+a.getStu_id()+"<br>");
				
				out.println("student name: "+a.getStu_name()+"<br>");
				out.println("student Address: "+a.getStu_Address()+"<br>");
				out.println("student Contact: "+a.getStu_contact()+"<br>");
				out.println("student gender: "+a.getStu_gen()+"<br>");
				out.println("<br>");
				}
				tx.commit();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

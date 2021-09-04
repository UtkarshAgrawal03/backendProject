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
 * Servlet implementation class teacher_display
 */
@WebServlet("/teacher_display")
public class teacher_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		teacher_table ob=new teacher_table();
		Configuration con=new Configuration().configure().addAnnotatedClass(stud_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class);
				ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
				SessionFactory sf=con.buildSessionFactory(reg);
				Session s1=sf.openSession();
				Transaction tx=s1.beginTransaction();
				ob=(teacher_table)s1.get(teacher_table.class,Integer.parseInt(request.getParameter("did")));
				tx.commit();
				PrintWriter out=response.getWriter();
				if(ob!=null) {
				out.println("Teacher id: "+ob.getT_id()+"\n");
				out.println("Teacher name: "+ob.getT_name()+"\n");
				out.println(" Teacher Specializtaion: "+ob.getT_spec()+"\n");
				
				out.println("Teacher gender: "+ob.getT_gen()+"\n");
				}
				else {
					response.sendRedirect("Teacher_disp.jsp");
				}
				}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

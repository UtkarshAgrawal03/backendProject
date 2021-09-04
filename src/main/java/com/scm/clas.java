package com.scm;

import java.io.IOException;
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
 * Servlet implementation class clas
 */
@WebServlet("/clas")
public class clas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	class_table ob=new class_table();
	teacher_table t=new teacher_table();
	t.setT_id(Integer.parseInt(request.getParameter("tid")));
		
		ob.setStd(Integer.parseInt(request.getParameter("cstd")));
		ob.setClass_teacher(t);
	
		Configuration con=new Configuration().configure().addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s1=sf.openSession();
		Transaction tx=s1.beginTransaction();
		s1.save(ob);
		tx.commit();
		response.sendRedirect("Class_add.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

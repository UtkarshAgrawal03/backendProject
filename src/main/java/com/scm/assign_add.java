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
 * Servlet implementation class assign_add
 */
@WebServlet("/assign_add")
public class assign_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assign_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Assigned_table ob=new Assigned_table();
		class_table c=new class_table();
		sub_table s=new sub_table();
		teacher_table t=new teacher_table();
		t.setT_id(Integer.parseInt(request.getParameter("tid")));
		s.setSub_id(Integer.parseInt(request.getParameter("sid")));
		c.setStd(Integer.parseInt(request.getParameter("cid")));
			
			
			ob.setcId(c);
			ob.setSubId(s);
			ob.setTid(t);
		
			Configuration con=new Configuration().configure().addAnnotatedClass(sub_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class).addAnnotatedClass(Assigned_table.class);
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf=con.buildSessionFactory(reg);
			Session s1=sf.openSession();
			Transaction tx=s1.beginTransaction();
			s1.save(ob);
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

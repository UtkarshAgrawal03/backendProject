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
 * Servlet implementation class st_add
 */
@WebServlet("/st_add")
public class st_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public st_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stud_table ob=new stud_table();
		class_table t=new class_table();
		t.setStd(Integer.parseInt(request.getParameter("sclass")));
			
			ob.setStu_name(request.getParameter("sname"));
			ob.setStu_Address(request.getParameter("saddress"));

			ob.setStu_contact(Long.parseLong(request.getParameter("scon")));
			ob.setStu_gen((request.getParameter("sgen").charAt(0)));
			ob.setStu_class(t);
		
			Configuration con=new Configuration().configure().addAnnotatedClass(stud_table.class).addAnnotatedClass(class_table.class).addAnnotatedClass(teacher_table.class);
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sf=con.buildSessionFactory(reg);
			Session s1=sf.openSession();
			Transaction tx=s1.beginTransaction();
			s1.save(ob);
			tx.commit();
			response.sendRedirect("Stud_add.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

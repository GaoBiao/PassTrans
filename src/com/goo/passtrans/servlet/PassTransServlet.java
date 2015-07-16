package com.goo.passtrans.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goo.passtrans.comment.Constants;

public class PassTransServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/javascript");
		String pass = null;
		String token = req.getParameter("token");
		Constants.passMap.put(token, null);
		System.out.println(token);
		int i = 0;
		while (pass == null && i < 60) {
			i++;
			pass = Constants.passMap.get(token);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Constants.passMap.remove(token);
		if (pass != null) {
			resp.getWriter().print("pt_inputPass('" + URLEncoder.encode(pass, "UTF-8") + "')");
		} else {
			resp.getWriter().print("pt_timeout()");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String token = req.getParameter("token").toLowerCase();
		String pass = req.getParameter("pass");
		System.out.println(pass);
		if (Constants.passMap.keySet().contains(token)) {
			Constants.passMap.put(token, pass);
		}
	}
}

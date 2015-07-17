package com.raremile.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raremile.serviceInterfaces.ExecuteResult;

public class ExecuteResultImpl implements ExecuteResult{

	public void getResult(Connection conn, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			// Execute SQL query
			String userName = request.getParameter("username");
			String userPassword = request.getParameter("password");
			PreparedStatement exStmt = conn
					.prepareStatement("SELECT * FROM USER WHERE username = ? AND password = ?");
			PreparedStatement exStmtUserProfile = conn
					.prepareStatement("SELECT * FROM USERPROFILE WHERE userid = ?");

			exStmt.setString(1, userName);
			exStmt.setString(2, userPassword);
			ResultSet rs = exStmt.executeQuery();
			int exist = 0;
			int userId = 0;
			String userRole = null;
			while (rs.next()) {
				exist = 1;
				userId = Integer.parseInt(rs.getString("id"));
			}

			if (exist == 1) {
				try {
					exStmtUserProfile.setInt(1, userId);
					ResultSet rs_usr = exStmtUserProfile.executeQuery();
					while (rs_usr.next()) {
						if (rs_usr.getString("role").equalsIgnoreCase("Admin")) {
							userRole = "Admin";
						}
						if (rs_usr.getString("role")
								.equalsIgnoreCase("Manager")) {
							userRole = "Manager";
						}
						if (rs_usr.getString("role").equalsIgnoreCase(
								"Developer")) {
							userRole = "Developer";
						}
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/WEB-INF/view/welcomeUser.jsp?userName="
										+ userName
										+ "&userId="
										+ userId
										+ "&userRole=" + userRole);

						//
						dispatcher.forward(request, response);
						return;
						//
					}

				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				try {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/view/loginFailure.jsp");

					dispatcher.forward(request, response);
					return;
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// End method
	}
}

package com.raremile.serviceInterfaces;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExecuteResult {
	void getResult(Connection conn, HttpServletRequest request,
			HttpServletResponse response);
}

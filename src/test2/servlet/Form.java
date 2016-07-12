package test2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectionManager;

/**
 * Servlet implementation class Form
 */
@WebServlet("/InputFormServlet")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	서블릿에서 한번만 객체를 생성하는 경우는 init 메소드를 사용
//	서블릿은 스레드 형태로 진행되다가 시스템에서 제거되면 destroy메소드를 오버라이딩해서 씀 
	
	
	/**여러번 제출 받는 경우 get, post 씀 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");// 저장대화상자 오타나면 100%
															// 여기 에러

		PrintWriter pw = response.getWriter();
		String name = request.getParameter("u_name");// HTML tag의 name 속성값과 일치해야함
		String age = request.getParameter("u_age");// HTML tag의 name 속성값과 일치해야함
		String gender = request.getParameter("u_gender");// HTML tag의 name 속성값과 일치해야함
		String tmp = "a";
		
		pw.println("이름은 : "+name+" 입니다.<br>");
		pw.println("나이는 : "+age+"세 입니다.<br>");
		pw.println("성별은 : "+gender+" 입니다.<br>");
		
		Connection con = ConnectionManager.getConnection(); 
		String sql = "insert into userinfo values(id_seq.nextval,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, Integer.parseInt(age));
			pstmt.setString(3, gender);
			pstmt.setString(4, tmp);
			System.out.println("실행");
			ResultSet rs = pstmt.executeQuery(); 
			System.out.println(rs+" 결과");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
			} catch (Exception e2) {
			}
		}
		
	}

}

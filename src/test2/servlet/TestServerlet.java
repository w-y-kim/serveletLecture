package test2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServerlet
 */
@WebServlet("/TestServlet") /*외부에서 부를 때 쓰는 이름, 원래는 web_inf의 web.xml에서 정의했어야 함*/
public class TestServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/* doGet메소드 오버라이딩 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request 밖에서 들어오는 요청(부를 때 정보) , response 응답
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");//저장대화상자 오타나면 100% 여기 에러 
		
		PrintWriter pw = response.getWriter(); 
	
		pw.println("<html>");
		pw.println("<body>");
		pw.println("TestServlet 실행</br>");
		pw.println("<fieldset><img src=\"./img/img01.png\"></fieldset>");
		pw.println("</body>");
		pw.println("</html>");
	}

}

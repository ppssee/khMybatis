package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
@WebServlet("/notice/remove.do")
public class NoticeRemoveController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNum = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(noticeNum);
		NoticeService nService = new NoticeServiceImpl();
		int result = nService.removeNotice(noticeNo);
		if(result >0) {
			response.sendRedirect("/notice/list.do");
		} else {
			request.setAttribute("title", "서비스 실패");
			request.setAttribute("msg", "공지사항 삭제가 완료되지 않았습니다.");
			request.setAttribute("url", "/notice/detail.do?notice-no="+noticeNo);
			request.getRequestDispatcher("WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}

package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;


@WebServlet("/notice/modify.do")
public class NoticeModfiyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNum = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(noticeNum);
		NoticeService nService = new NoticeServiceImpl();
		Notice notice = nService.printOneByNo(noticeNo);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String noticeNum = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(noticeNum);
		Notice notice = new Notice(noticeNo, subject, content, "admin");
		NoticeService nService = new NoticeServiceImpl();
		int result = nService.modifyNotice(notice);
		if(result > 0) {
			response.sendRedirect("/notice/detail.do?notice-no="+noticeNo);
		} else {
			request.setAttribute("title","서비스 실패");
			request.setAttribute("msg", "공지사항 수정 실패");
			request.setAttribute("url", "/notice/detail.do?notice-no="+noticeNo);
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}

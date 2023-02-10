package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagination;


@WebServlet("/notice/list.do")
public class NoticeListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int page= 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Pagination pagination = new Pagination(page, 10);
		NoticeService nService = new NoticeServiceImpl();
		
		PageData pd = nService.printAllNotice(pagination);
		List<Notice> nList = pd.getNoticeList();
		String pageNavi = pd.getPageNavigator();
		if(!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
		} else {
			request.setAttribute("title","서비스 실패");
			request.setAttribute("msg", "공지사항 목록 조회 실패");
			request.setAttribute("url", "/notice/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}


}

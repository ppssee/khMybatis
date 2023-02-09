package notice.model.service;

import java.util.List;

import notice.model.vo.Notice;

public interface NoticeService {
	/**
	 * 공지사항 등록 service
	 * @param notice
	 * @return int 
	 */
	public int insertNotice(Notice notice);
	/**
	 *  공지사항 목록 출력 service
	 * @return
	 */
	public List<Notice> printAllNotice();
	
}

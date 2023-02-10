package notice.model.service;

import java.util.List;

import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagination;

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
	public PageData printAllNotice(Pagination pagination);
	/**
	 * 공지사항 상세 조회 service
	 * @param noticeNo
	 * @return
	 */
	public Notice printOneByNo(int noticeNo);
	/**
	 * 공지사항 삭제 service
	 * @param noticeNo
	 * @return
	 */
	public int removeNotice(int noticeNo);
	/**
	 * 공지사항 수정 service
	 * @param notice
	 * @return
	 */
	public int modifyNotice(Notice notice);
	
}

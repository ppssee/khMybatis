package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.Pagination;

public interface NoticeStore {
	/**
	 * 공지사항 등록 store
	 * @param sqlSession
	 * @param notice
	 * @return int
	 */
	public int insertNotice(SqlSession sqlSession, Notice notice);
	/**
	 * 공지사항 목록 조회 store
	 * @return List<Notice>
	 */
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagination pagination);
	/**
	 * 공지사항 목록 페이지 네비게이터 store
	 * @param sqlSession
	 * @param currentPage
	 * @return String
	 */
	public String generatePageNavi(SqlSession sqlSession, int currentPage);
	/**
	 * 공지사항 전체 게시물 갯수 store
	 * @param sqlSession
	 * @return
	 */
	public int getRecordTotalCount(SqlSession sqlSession);
	/**
	 * 공지사항 상세조회 store
	 * @param sqlSession
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectOneByNo(SqlSession sqlSession, int noticeNo);
	/**
	 * 공지사항 삭제 store
	 */
	public int deleteNotice(SqlSession sqlSession, int noticeNo);
	/**
	 * 공지사항 정보 수정 store
	 * @param sqlSession
	 * @param notice
	 * @return int
	 */
	public int updateNotice(SqlSession sqlSession, Notice notice);
	
}

package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public interface NoticeStore {
	/**
	 * 공지사항 등록 store
	 * @param sqlSession
	 * @param notice
	 * @return
	 */
	public int insertNotice(SqlSession sqlSession, Notice notice);
	/**
	 * 공지사항 목록 조회 store
	 * @return
	 */
	public List<Notice> selectAllNotice(SqlSession sqlSession);
	
}

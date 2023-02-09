package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class noticeStoreLogic implements NoticeStore{

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<Notice> selectAllNotice(SqlSession sqlSession) {
		List<Notice> nList = sqlSession.selectList("NoticeMapper.selectAllNotice");
		return nList;
	}


}

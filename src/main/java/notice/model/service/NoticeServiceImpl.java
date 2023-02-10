package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.store.NoticeStore;
import notice.model.store.noticeStoreLogic;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagination;

public class NoticeServiceImpl implements NoticeService{
	private NoticeStore nStore = null;
	
	public NoticeServiceImpl() {
		nStore = new noticeStoreLogic();
	}
	
	public int insertNotice(Notice notice) {
		// 1. 연결 생성 -> Store 전달
		// 2. 커밋/롤백
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.insertNotice(sqlSession, notice);
		sqlSession.commit();
		return result;
	}

	@Override
	public PageData printAllNotice(Pagination pagination) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nStore.selectAllNotice(sqlSession, pagination);
		String pageNavigator = nStore.generatePageNavi(sqlSession, pagination.getCurrentPage());
		PageData pageData = new PageData();
		pageData.setNoticeList(nList);
		pageData.setPageNavigator(pageNavigator);
		return pageData;
	}

	@Override
	public Notice printOneByNo(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		Notice notice = nStore.selectOneByNo(sqlSession, noticeNo);
		return notice;
	}

	@Override
	public int removeNotice(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.deleteNotice(sqlSession, noticeNo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int modifyNotice(Notice notice) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.updateNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}

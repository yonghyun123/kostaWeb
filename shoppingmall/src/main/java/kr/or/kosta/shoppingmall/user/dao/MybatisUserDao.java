package kr.or.kosta.shoppingmall.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import kr.or.kosta.shoppingmall.common.web.Params;
import kr.or.kosta.shoppingmall.user.domain.User;

public class MybatisUserDao implements UserDao {
	
	private static final String NAMESPACE = "kr.or.kosta.shoppingmall.user.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert(NAMESPACE + "createUser", user);
		sqlSession.commit();
	}

	// 아이디를 통해 회원정보 읽기
	@Override
	public User read(String id) throws Exception {
		User user = null;
		try(SqlSession sqlSession = sqlSessionFactory.openSession();){
			user = sqlSession.selectOne(NAMESPACE + "selectUserById", id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}


	@Override
	public void update(User user) throws Exception {

	}

	@Override
	public void delete(String id) throws Exception {

	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
	    list = sqlSession.selectList(NAMESPACE+"selectAll");
	    sqlSession.close();
	    return list;
	}
	

	@Override
	public User certify(String id, String passwd) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("passwd", passwd);
		User user = sqlSession.selectOne(NAMESPACE + "selectCheckUser", params);
		return user;
	}

	
	private User createUser(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPasswd(rs.getString("passwd"));
		user.setEmail(rs.getString("email"));
		user.setRegdate(rs.getString("regdate"));
		return user;
	}
	
	
	@Override
	public List<Map<String, String>> employeeList() throws Exception {
		return null;
	}

	@Override
	public List<User> listByPage(int page) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList(NAMESPACE+"selectUserByPage", page);
		return list;
	}

	@Override
	public List<User> listByPage(int page, int listSize) throws Exception {
		return null;
	}

	@Override
	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> param = new HashMap<>();
        if(searchType.equals("name")) searchValue = "%" + searchValue + "%";
        param.put("listSize", listSize);
        param.put("page", page);
        param.put("searchType", searchType);
        param.put("searchValue", searchValue);
        List<User> list = sqlSession.selectList(NAMESPACE+"selectUserByParam", param);
        return list;

	}

	@Override
	public List<User> listByPage(Params params) throws Exception {
		 return listByPage(params.getPage(), params.getListSize(),  params.getSearchType(), params.getSearchValue());
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<>();
		if(searchType.equals("name")) searchValue = "%" + searchValue + "%";
		param.put("searchType", searchType);
		param.put("searchValue", searchValue);
		int count = sqlSession.selectOne(NAMESPACE+"countByParam", param);
		return count;

	}

	@Override
	public int countBySearch(Params params) throws Exception {
		return countBySearch(params.getSearchType(), params.getSearchValue());
	}
}











package kr.or.kosta.shoppingmall;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.user.dao.MybatisUserDao;
import kr.or.kosta.shoppingmall.user.dao.UserDao;

public class UserDaoTest {
    private static String NAMESPACE = "kr.or.kosta.shoppingmall.employee."; 
    String resource = "mybatis-config.xml"; //resource 밑에 바로 있으니까~ resource 기준임
    SqlSessionFactory sqlSessionFactory;
    
    Logger logger = Logger.getLogger(UserDaoTest.class);
    UserDao userDao;
   
   @Before
    public void setup() {
       Reader reader = null;
       try {
          reader = Resources.getResourceAsReader(resource);
       } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
       logger.debug("sqlSessionFactory 생성 완료!");
       userDao = new MybatisUserDao();
       ((MybatisUserDao)userDao).setSqlSessionFactory(sqlSessionFactory);
   }
   
//   @Test
//   public void testUserMybatis() throws Exception {
//      logger.debug("생성 완료!");
//      List<User> list = userDao.listAll();
//   }
   
//   @Test
//   public void testUserRead() throws Exception {
//      logger.debug("생성 완료!");
//      User user = userDao.read("bangry");
//      logger.debug(user.toString());
//   }
//   
//   @Test
//   public void testUserCheck() throws Exception {
//      logger.debug("생성 완료!");
//      User user = userDao.certify("bangry", "1111");
//      logger.debug(user.toString());
//   }
//   @Test
//   public void testCreateUser() throws Exception {
//      logger.debug("생성 완료!");
//      User user = new User();
//      user.setId("kim");
//      user.setEmail("model9960@naver.com");
//      user.setName("김용현");
//      user.setPasswd("1111");
//      userDao.create(user);
//   }
   
//   @Test
//   public void testByPage() throws Exception {
//      logger.debug("생성 완료!");
//      List<User> list = userDao.listByPage(1);
//      for (User user : list) {
//		logger.debug(user.toString());
//	}
//   }
//   
//   @Test
//   public void testByParams() throws Exception {
//      logger.debug("생성 완료!");
//      List<User> list = userDao.listByPage(1, 10, "name", "김");
//      for (User user : list) {
//		logger.debug(user.toString());
//      }
//   }
   @Test
   public void testByCount() throws Exception {
      logger.debug("생성 완료!");
      int count = userDao.countBySearch("name", "김");
      logger.debug(count);
   }
   
   
//    @Test
//    public void dynamicSql() {
//
//    	Map<String, String> map = new HashMap<>();
//    	map.put("searchType", "id");
//    	map.put("searchValue", "100");
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Employee> list = sqlSession.selectList(NAMESPACE+"dynamicSQL", map);
//        
//        for (Employee employee : list) {
//			System.out.println(employee.toString());
//		}
//    } 
//   
   
}
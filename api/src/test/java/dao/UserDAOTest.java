package dao;

import com.ky.ApiApplication;
import com.ky.ClassBrrowSystem.dao.UserDAO;
import com.ky.ClassBrrowSystem.enity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class UserDAOTest {
    @Resource
    private UserDAO userDAO;

//    @Test
//    public void queryUserByName() {
//        User user = userDAO.queryUserByName("张开源");
//        System.out.println(user);
//    }

    @Test
    public void queryUserById() {
        User user = userDAO.queryUserById("20110501089");
        System.out.println(user);
    }
}
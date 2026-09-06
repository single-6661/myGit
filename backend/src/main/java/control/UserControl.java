package control;



import jakarta.servlet.http.HttpSession;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DataInsertService;
import service.UserService;

@RestController
public class UserControl {

    private static final Logger LOG = LoggerFactory.getLogger(UserControl.class);

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    //登录后端查询mongodb，返回boolean值
    public Boolean login(@RequestBody User user,HttpSession session){
        User user1 = userService.queryUser(user);

        if(user1 != null){
            session.setAttribute("user",user1);
            LOG.info("user login success");
            return true;
        }
        LOG.info("user login failed");
        return false;
    }

}


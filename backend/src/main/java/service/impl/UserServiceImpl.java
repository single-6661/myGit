package service.impl;



import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.UserService;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    //查询用户信息
    public User queryUser(User user) {
        Criteria criteria = new Criteria();

        List<Criteria> criteriaList = new ArrayList<>();

        if(StringUtils.hasText(user.getMobile())){
            criteriaList.add( Criteria.where("mobile").is(user.getMobile()));
        }

        if(StringUtils.hasText(user.getPassword())){
            criteriaList.add( Criteria.where("password").is(user.getPassword()));
        }

        criteria = criteria.andOperator(criteriaList.toArray(new Criteria[criteriaList.size()]));

        Query query = new Query();
        query.addCriteria(criteria);
        List<User> user1 = mongoTemplate.find(query, User.class);

        if(user1 == null || user1.isEmpty()){
            LOG.info("没有匹配的用户");
            return null;
        }

        if(criteriaList.isEmpty()){
            LOG.info("user not found");
            return null;
        }

        LOG.info("user found");
        return user1.get(1);

    }



}

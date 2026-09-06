package control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DataInsertService;
import service.MongodbServive;


//用于测试api和mongodb是否运行和填入数据成功
@RestController
public class RunControl {

    @Autowired
    private DataInsertService dataInsertService;
    @Autowired
    private MongodbServive mongodbServive;

    private static final Logger LOG = LoggerFactory.getLogger(RunControl.class);


    @GetMapping("/run")
    public String runTask() {
        //contentService.getApiContent();success
        //contentService.getApiHot();success
        return "1";
    }

    //数据库插入数据，仅执行一次！！！
    @GetMapping("/insert")
    public String insertTask() {
            //mongodbServive.insertContent();
            //mongodbServive.insertHot();
            //mongodbServive.insertUser();
        return "1";
    }
}



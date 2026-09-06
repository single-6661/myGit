package control;

import com.alibaba.fastjson.JSON;
import model.Content;
import model.Hot;
import model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GetDataService;
import service.SearchService;

import java.util.List;

@RestController
public class ContentControl {

    private static final Logger LOG = LoggerFactory.getLogger(ContentControl.class);

    @Autowired
    private GetDataService getDataService;
    @Autowired
    private SearchService searchService;

    @GetMapping("/contentCard")
    public Result<?> getContent() {
        Content[] contentData = getDataService.getContent().toArray(new Content[0]);
        //System.out.println(JSON.toJSONString(contentData));
        return Result.success(contentData);
    }

    @GetMapping("/hot")
    public Result<?> getHot() {
        Hot[] hotData = getDataService.getHot().toArray(new Hot[0]);
        //System.out.println(JSON.toJSONString(hotData));
        return Result.success(hotData);
    }

    @GetMapping("/search")
    public Result<?> getSearch(@RequestParam String keyword) {
        List<Content> contentData = searchService.searchAct(keyword);

        //如果查询判空则发送fail
        if (contentData.isEmpty()) {
            LOG.error("search is empty!!!");
            return Result.fail();
        }

        LOG.info("search success!!!");
        //LOG.info(JSON.toJSONString(contentData));
        return Result.success(contentData);
    }

}

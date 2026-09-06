package service.impl;

import com.alibaba.fastjson.JSON;
import model.Content;
import model.Hot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import service.DataInsertService;
import utils.Utils;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DataInsertServiceImpl implements DataInsertService {
    private static final Logger LOG = LoggerFactory.getLogger(DataInsertServiceImpl.class);

    @Override
    public List<Content> getApiContent() {

        List<Map<String,Object>> items = Utils.requestApi("https://developer.zhihu.com/api/v1/content/global_search?Query=java&Count=20");

        List<Content> contents = new ArrayList();

        //向content中填入数据
        for (Map item : items) {
            Content content = new Content();
            content.setContentText(item.get("ContentText").toString());
            content.setAuthorAvatar(item.get("AuthorAvatar").toString());
            content.setAuthorName(item.get("AuthorName").toString());
            content.setTitle(item.get("Title").toString());
            content.setCommentCount(item.get("CommentCount").toString());
            content.setVoteUpCount(item.get("VoteUpCount").toString());

            //日期单独处理
            String time = item.get("EditTime").toString();
            int day = Integer.parseInt(time);
            day *= 1000;
            Instant instant = Instant.ofEpochMilli(day);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM‑dd");
            String timeResult = localDateTime.format(fmt);
            content.setDate(timeResult);
            //检测是否成功转化为日期
            //System.out.println(content.getDate());


            contents.add(content);
        }

        System.out.println(JSON.toJSONString(contents));
        return contents;
    }

    @Override
    public List<Hot> getApiHot() {
        Utils utils = new Utils();
        List<Map<String,Object>> item = utils.requestApi("https://developer.zhihu.com/api/v1/content/hot_list?Count=10");
        List<Hot> hots = new ArrayList();

        for (Map item1 : item) {
            Hot hot = new Hot();
            hot.setHot(item1.get("Title").toString());
            hots.add(hot);
        }

        System.out.println(JSON.toJSONString(hots));
        return hots;
    }


}

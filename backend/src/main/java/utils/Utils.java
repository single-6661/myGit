package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import model.Content;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    //请求知乎api
    public static  List<Map<String,Object>> requestApi(String url){
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("X-Request-Timestamp", timestamp )
                .header("Authorization", "Bearer 0c4f467d58eea961d130baf222f649edb7b142f6")
                .url(url)
                .build();
        Call call = client.newCall(request);

        String jsonData = null;
        try{
            jsonData = call.execute().body().string();
            System.out.println(jsonData);
        } catch (IOException e) {
            System.out.println("请求错误");
        }


        List<Content> contents = new ArrayList();

        Map cotentObj = JSON.parseObject(jsonData, Map.class);
        Map dataObj = (Map) cotentObj.get("Data");


        JSONArray jsonArray = (JSONArray) dataObj.get("Items");
        List<Map<String,Object>> items = new ArrayList<>();

        if(jsonArray != null){
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                items.add(jo);
            }
        }

        return items;
    }
}

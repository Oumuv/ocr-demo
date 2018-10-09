package com.oumuv.orc.utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/9 14:16
 **/
public class OcrUtilTool {

    //设置APPID/AK/SK
    public static final String APP_ID = "14383786";
    public static final String API_KEY = "5s4u6bnyedvBlKwPshZLDHkX";
    public static final String SECRET_KEY = "bcwmgRjTtNe4V1Rp9u9g4nORWfNSih3P";
    private static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    public static String getImgText(MultipartFile file) throws IOException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        byte[] bytes = file.getBytes();
        JSONObject jsonObject = client.basicAccurateGeneral(bytes,options);
        long log_id = jsonObject.getLong("log_id");
        JSONArray jsonArray = jsonObject.getJSONArray("words_result");
        int result_count = jsonObject.getInt("words_result_num");
        return jsonObject.toString();
    }
}

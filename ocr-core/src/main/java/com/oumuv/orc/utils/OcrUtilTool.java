package com.oumuv.orc.utils;

import com.baidu.aip.ocr.AipOcr;
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
    public static final String APP_ID = "14377502";
    public static final String API_KEY = "p9eH47qcXj8GknZdGmw1Ib9p";
    public static final String SECRET_KEY = "sKfRgSiZr3F1t297IrHjOmCMe37GVRDG";
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
        return jsonObject.toString();
    }
}

package com.oumuv.orc.utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    //TODO APPID/AK/SK这些参数暂时使用的个人设置的参数
    private static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);


    /**
     * 通用文字识别
     * 用户向服务请求识别某张图中的所有文字
     * 50000次/天免费
     * @param file_bytes 图片二进制码
     * @param options 请求参数(可选)
     * @return
     */
    public static JSONObject basicGeneral(byte[] file_bytes,HashMap<String, String> options) {
        if (options == null) {//设置默认参数
            options = new HashMap<>();
            options.put("language_type", "CHN_ENG");
            options.put("detect_direction", "true");
            options.put("detect_language", "true");
            options.put("probability", "true");
        }
        JSONObject jsonObject = client.basicGeneral(file_bytes, options);
        return jsonObject;
    }

    /**
     * 通用文字识别（高精度版）
     * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     * 500次/天免费
     * @param file_bytes
     * @param options
     * @return
     */
    public static JSONObject basicAccurateGeneral(byte[] file_bytes,HashMap<String, String> options) {
        if (options == null) {//设置默认参数
            options = new HashMap<>();
            options.put("detect_direction", "true");
            options.put("probability", "true");
        }

        JSONObject jsonObject = client.basicAccurateGeneral(file_bytes, options);
        return jsonObject;
    }

    /**
     * 表格文字识别同步接口
     * 自动识别表格线及表格内容，结构化输出表头、表尾及每个单元格的文字内容。
     * @param file_bytes
     * @param options
     * @return
     */
    public static JSONObject readForm(byte[] file_bytes,HashMap<String, String> options) {
        JSONObject form = client.form(file_bytes, options);
        return form;
    }

    public static JSONObject tableRecognitionAsync(byte[] file_bytes,HashMap<String, String> options) {
        JSONObject form = client.tableRecognitionAsync(file_bytes, options);
        return form;
    }

    public static JSONObject tableResultGet(String requestID, HashMap<String, String> options) {
        if (options == null) {//设置默认参数
            options.put("result_type", "json");
        }
        JSONObject res = client.tableResultGet(requestID, options);
        return res;
    }


    /**
     * =============================================================================================
     */


    /**
     * 解析数据
     * @param jsonObject
     * @return
     */
    public static Map<String,Object> analyseData(JSONObject jsonObject) {
        Map<String, Object> stringObjectMap = jsonObject.toMap();
        long log_id = jsonObject.getLong("log_id");//获取日志id
        int words_result_num = jsonObject.getInt("words_result_num");//结果数
        Object words_result = stringObjectMap.get("words_result");//结果集
        JSONArray words_result1 = jsonObject.getJSONArray("words_result");

        String[] words = new String[words_result_num];
        for (int i = 0; i < words_result_num; i++) {
            words[i] = words_result1.getJSONObject(i).getString("words");
        }
        Map result = new HashMap();
        result.put("words_result", words);
        return result;
    }
}

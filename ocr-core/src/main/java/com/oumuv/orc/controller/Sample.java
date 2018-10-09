package com.oumuv.orc.controller;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/9 14:03
 **/
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "14377502";
    public static final String API_KEY = "p9eH47qcXj8GknZdGmw1Ib9p";
    public static final String SECRET_KEY = "sKfRgSiZr3F1t297IrHjOmCMe37GVRDG";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\bonoon\\Desktop\\556891155837210784.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }

}

package com.oumuv.orc.controller;

import com.oumuv.orc.utils.OcrUtilTool;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/9 16:06
 **/

@Controller
public class UploadImag {

    @ResponseBody
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object upload(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("file");
        try {
            JSONObject jsonObject = OcrUtilTool.basicAccurateGeneral(file.getBytes(), null);
            return jsonObject;
        } catch (IOException e) {
            return e;
        }


    }
}

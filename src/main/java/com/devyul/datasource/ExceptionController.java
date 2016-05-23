package com.devyul.datasource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**错误页面Controller
 * Created by Stone on 16/5/23.
 */
@RestController
public class ExceptionController {

    @RequestMapping("/404")
    @ResponseBody
    public String showServerError() {
        String errJSON = "{\n" +
                "  \"isSuccess\": false,\n" +
                "  \"errMsg\": \""+"访问路径有误,示例: http://192.168.2.9:8053/JSON?method=login "+"\"\n" +
                "}";
        return  errJSON;
    }
}
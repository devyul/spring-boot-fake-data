package com.devyul.datasource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取method参数值,来获取对应名称的txt文本内容直接返回
 * 访问示例:  http://localhost:8080/JSON?method=getTeacherList   获取getTeacherList接口内容
 */
@Controller
public class JsonController {


    /**文件绝对路径*/
    public  static  String FILE_PATH = "/Users/Stone/Documents/ZTTC_JSON/";

    /**key xxx.txt == value /User/Stone/Documents/xxx.txt*/
    public Map<String,String>  allFilePathMap = new HashMap<String,String>();


    @RequestMapping("/JSON")
    @ResponseBody
    public String getJSONxx(String method) {

        String jsonStr;
        try {
            if ("".equals(method) || null ==method ){throw  new Exception("method不能为空,访问示例:http://192.168.2.9:8080/JSON?method=login");};
            ReadAllFile(FILE_PATH);
            String filePath= allFilePathMap.get(method+".txt");
            if ("".equals(filePath) || null ==filePath ){throw  new Exception("文件不存在,请检查文件是否存在,或文件名是否一致. 如:method=login 对应login.txt");};
            jsonStr = readFileContent(filePath);
        }catch (Exception e){
            String errJSON = "{\n" +
                    "  \"isSuccess\": false,\n" +
                    "  \"errMsg\": \""+e.getMessage()+"\"\n" +
                    "}";
            return  errJSON;
        }
        return jsonStr;
    }


    @RequestMapping(value="/POSTJSON", method= RequestMethod.POST)
    @ResponseBody
    public String postMethod(@RequestBody String method) {
        return getJSONxx(method);
    }



//    /**Test  mvn打包的时候注释掉*/
//    public static void main(String[] args) {
//       new JsonController(). ReadAllFile(FILE_PATH);
//    }

    //读取一个文件夹下所有文件及子文件夹下的所有文件
    public void ReadAllFile(String filePath) {
        File f = null;
        f = new File(filePath);
        File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。
        List<File> list = new ArrayList<File>();
        for (File file : files) {
            String firstStr = file.getName().substring(0,1);
            //过滤Mac文件系统的无用文件\文件夹  .DS_Store  .com.apple..xxx
            if(!firstStr.equals(".")) {
                if ( file.isDirectory()) {
                    //如何当前路劲是文件夹，则循环读取这个文件夹下的所有文件
                    ReadAllFile(file.getAbsolutePath());
                } else {
                    System.out.println("fileName==" + file.getName() + "==path:==" + file.getAbsolutePath());
                    allFilePathMap.put(file.getName(), file.getAbsolutePath());
                }
            }else { //无用文件
            }
        }
    }


    /**读取txt内容*/
    private static String readFileContent(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream in = new FileInputStream(file);
        BufferedReader bf = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        String content = "";
        StringBuilder sb = new StringBuilder();
        while(content != null){
            content = bf.readLine();
            if(content == null){
                break;
            }
            sb.append(content.trim());
        }
        bf.close();
        return sb.toString();
    }



    @RequestMapping("/")
    @ResponseBody
    public String hello(String method) {return  "hello zttc";}
}


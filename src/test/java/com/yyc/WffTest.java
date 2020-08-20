package com.yyc;

import com.alibaba.fastjson.JSON;
import com.wff.element.Driver;
import com.yyc.log.Log;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class WffTest {
    private static Logger logger = Log.logger(WffTest.class);
    @Test
    public void case01() throws Exception {
        // 用来保存结果
        String result;
        // 新建一个请求对象
        HttpGet get = new HttpGet("http://localhost:8080/test?name=aaa&age=111");
        // 新建一个httpClient 客户端
        HttpClient client = new DefaultHttpClient();
        // httpClient 执行请求对象并且返回结果
        HttpResponse response = client.execute(get);
        // 把结果以UTF-8形式存在result中
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        // 输出结果
        System.out.println("-------------------------");
        System.out.println(result);
    }


    @Test
    public void case02() throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://localhost:8080/test");
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("name", "xxxx"));//名值对
        nvps.add(new BasicNameValuePair("age", "122"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        HttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("Login form get: " + response.getStatusLine());//这个可以打印状态
        httpPost.abort();
        System.out.println(body);
        System.out.println(JSON.parse(body));
    }
}

package com.career.genius.utils.wechat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 微信分享工具类
 *
 * @author Marker
 * @time 2019-07-09 14:25
 * @discription
 **/
public class ShareUtil {

    // 获取access_token
    public static String getToken(String apiurl, String appid, String secret){
        //拼接访问地址
        String turl = String.format("%s?grant_type=client_credential&appid=%s&secret=%s", apiurl,appid, secret);

        HttpClient client = new DefaultHttpClient();
        //get请求
        HttpGet get = new HttpGet(turl);
        // 初始化解析json格式的对象
        JsonParser jsonparer = new JsonParser();
        String result = null;
        try
        {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 初始化响应内容
            HttpEntity entity = (HttpEntity) res.getEntity();
            //设置编码格式
            responseContent = EntityUtils.toString((org.apache.http.HttpEntity) entity, "UTF-8");
            // 将json字符串转换为json对象
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();

            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            {
                if (json.get("errcode") != null){
                    // 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                }
                else{
                    // 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                    result = json.get("access_token").getAsString();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            return result;
        }
    }

    // 获取getTicket
    public static String getTicket(String apiurl,String access_token){

        String turl = String.format("%s?access_token=%s&type=jsapi",apiurl,access_token);

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(turl);

        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
        String result = null;
        try
        {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();

            // 将json字符串转换为json对象
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                if (json.get("errcode") == null){
                    // 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                }
                else{
                    // 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                    result = json.get("ticket").getAsString();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            return result;
        }
    }
}

package com.career.genius.utils.signcode;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * 签名算法
 */
public class SignCode {

    /**
     * 功能描述: 签名校验算法
     * @auther: luoqw
     * @date: 2018/6/20 16:11
     */
    public static String signCode(TreeMap<String,Object> map,String salt){
        StringBuilder appendString = new StringBuilder();
        Map<String, Object> resultMap = sortMapByKey(map);
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            if (!entry.getKey().equals("sign")){
                appendString.append(entry.getKey()+ entry.getValue());
            }
        }
        appendString.append(salt);
        return DigestUtils.md5Hex(appendString.toString());
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortMap = new TreeMap<String, Object>(
                new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 获取noce随机字符串
     * @return
     */
    public static  String getRandomString(){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<5; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
     //   System.out.println("nonce------->" + sb.toString());
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("appkey","74c2aeb246144cf389b7e4257848ea18");
        map.put("nonce","py1j");
        map.put("ak","ZM_y0lCPScCCCYldv5l4Uw5");
        map.put("time",1533175760);
        String sign = signCode(map, "ba9fc1a86cf74872867a71e76bd7ba16");
        System.out.println(sign);
    }
}

package com.yyc.utils;

import java.util.Random;

public class MathRandom {

    // 生成15位字母数字组合随机数
    public static String getRandName() {
        String timeMillis = String.valueOf(System.currentTimeMillis());
        //  截取时间戳后7位
        String substring = timeMillis.substring(timeMillis.length() - 7);
        String stringRandom = getStringRandom(8);
        return stringRandom + substring;
    }

    // 生成字母+数字随机数
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if("char".equalsIgnoreCase(charOrNum)){
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            }else if("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static void main(String[] args) {
        String timeMillis = String.valueOf(System.currentTimeMillis());
        //  截取时间戳后7位
        String substring = timeMillis.substring(timeMillis.length() - 7);
        System.out.println(timeMillis);
    }
}

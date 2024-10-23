package cn.itcast.accountinglearn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class toolUtil {
    //判断字符串是否为空
    public static boolean isEmpty(String str){
         if(str != null && !"".equals(str.trim())){
             return false;
        }
         return true;
    }
    //获取当前时间
    public static long getTime(){
        long time =System.currentTimeMillis();
        return time;
    }
    //对时间进行格式化
    public static String getDateByTime(long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String string = format.format(new Date(time));
        return string;
    }

}

package cn.edu.whu.irlab.digsci.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gcr19
 * @date 2019-10-11 08:04
 * @desc
 **/
public class ListUtil {

    public static List<List<String>> splitList(List<String> orgin,int n){
        List<List<String>> output=new ArrayList<>();
        int num=orgin.size()/n;
        int left=orgin.size()%n;
        int startIndex=0;
        int endIndex=num;
        for (int i = 0; i <n ; i++) {
            List<String> sub=orgin.subList(startIndex,endIndex);
            startIndex=endIndex;
            if (i==n-2){
                endIndex+=left+num;
            }else {
                endIndex+=num;
            }
            output.add(sub);
        }
        return output;
    }
}

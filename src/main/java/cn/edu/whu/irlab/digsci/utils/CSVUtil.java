package cn.edu.whu.irlab.digsci.utils;

import cn.edu.whu.irlab.digsci.vo.Candidate;
import cn.edu.whu.irlab.digsci.vo.Validation;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gcr19
 * @date 2019-10-09 15:08
 * @desc 读取CSV内容
 **/
public class CSVUtil {

    public static List<Validation> readValadation(File file) throws IOException {
        List<String> strings = FileUtils.readLines(file, "UTF-8");
        List<Validation> validations = new ArrayList<>();
        for (String s :
                strings) {
            if (!s.equals(strings.get(0))){
                String[] line = s.split(",");
                validations.add(new Validation(line[0],line[1]));
            }
        }
        return validations;
    }

    public static List<Candidate> readCandidate(File file) throws IOException {
        List<String> strings = FileUtils.readLines(file, "UTF-8");
        List<Candidate> candidates= new ArrayList<>();
        for (String s :
                strings) {
            if (!s.equals(strings.get(0))){
                String[] line = s.split(",");

                candidates.add(new Candidate(line[0],line[1],line[2],line[3],line[4]));
            }
        }
        return candidates;
    }

}

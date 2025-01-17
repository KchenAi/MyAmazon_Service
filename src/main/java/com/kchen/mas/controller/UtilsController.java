package com.kchen.mas.controller;

import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/utils")
@RestController
public class UtilsController {

    @GetMapping("/jsData")
    public String jsData() {
        return "专门接受Automa数据界面";
    }

    @GetMapping("/splitStringCount")
    public List<String> splitString(@RequestHeader("My-Info") String str) {
        List<String> result =  new ArrayList<>();
        int xd = 4999;
        if (str.length() <= xd + 1) {
            result.add(str);
            return result;
        }
        String[] flag = new String[]{"----", "---", String.valueOf('.'), String.valueOf(';')};
        int index = xd;
        int strLen = str.length();
        List<Integer> resultIndex =  new ArrayList<>();
        int min = 0;
        while (index < strLen && index >= min) {
            String indexStr = String.valueOf(str.charAt(index));
            for (int j = 0; j < flag.length; j++) {
                if (indexStr.equals(flag[j])) {
                    boolean flag2 = false;
                    if (j == 2) {
                        flag2 = true;
                        if (!String.valueOf(str.charAt(index + 1)).equals(" ")) {
                            index--;
                            continue;
                        }
                    }
                    int indexAdd = 1;
                    if (flag2) {
                        indexAdd = 2;
                    }
                    min = index + indexAdd;
                    resultIndex.add(min);
                    if (index + xd + 1 < strLen) {
                        index += (xd + 1);
                    } else {
                        break;
                    }
                }
            }
            index--;
        }
        int start = 0;
        for (int index2 : resultIndex) {
            result.add(str.substring(start, index2));
            start = index2;
        }
        if (start < str.length()) {
            result.add(str.substring(start));
        }
        return result;
    }
}

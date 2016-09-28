package com.github.javadev.service;

import com.github.underscore.$;
import com.github.underscore.Function1;
import com.github.javadev.model.StringsParam;
import com.github.javadev.model.ResultResponse;
import com.github.javadev.model.StringResponse;

import java.util.*;

public class StringGeneratorService {

    public ResultResponse generate(StringsParam stringsParam) {
        List<Map<String, Object>> listOfMaps = generateListOfMaps(stringsParam.strings);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.result = new ArrayList<StringResponse>();
        for (Map<String, Object> item : listOfMaps) {
            StringResponse response = new StringResponse();
            response.string = (String) item.get("string");
            response.longestWord = (Integer) item.get("longestWord");
            resultResponse.result.add(response);
        }
        return resultResponse;
    }    

    public List<Map<String, Object>> generateListOfMaps(List<String> strings) {
        return (List<Map<String, Object>>) $.chain(strings)
            .map(
                new Function1<String, Map<String, Object>>() {
                public Map<String, Object> apply(String item) {
                    Map<String, Object> resultItem = new LinkedHashMap<String, Object>();
                    resultItem.put("string", item);
                    resultItem.put("longestWord", $.chain(Arrays.asList(item.split("\\s+"))).map(
                        new Function1<String, Integer>() {
                            public Integer apply(String item) {
                                return item.length();
                            }
                        })
                        .max().item());
                    return resultItem;
                }
            })
            .sortBy(new Function1<Map<String, Object>, Integer>() {
                public Integer apply(Map<String, Object> item) {
                    return -((Integer) item.get("longestWord"));
                }
            })
            .first(5)
            .value();
    }
}

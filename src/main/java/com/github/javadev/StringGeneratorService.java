package com.github.javadev;

import com.github.javadev.model.ResultResponse;
import com.github.javadev.model.StringResponse;
import com.github.javadev.model.StringsParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Component
public class StringGeneratorService implements GeneratorService {

	public ResultResponse generate(StringsParam stringsParam) {
        ResultResponse response = new ResultResponse();
        response.result = stringsParam.strings.stream()
            .map(line -> {
                StringResponse stringResponse = new StringResponse();
                stringResponse.string = line;
                stringResponse.longestWord = asList(line.split("\\s+")).stream()
                        .map(word -> word.length())
                        .max(Integer::compare).get();
                    return stringResponse;
                })
            .sorted((res1, res2) -> Integer.compare(res2.longestWord,
                    res1.longestWord))
            .limit(5)
            .collect(Collectors.toList());
            return response;
	}

}

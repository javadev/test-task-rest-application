package com.github.javadev;

import com.github.javadev.model.ResultResponse;
import com.github.javadev.model.StringsParam;

public interface GeneratorService {
    ResultResponse generate(StringsParam stringsParam);
}

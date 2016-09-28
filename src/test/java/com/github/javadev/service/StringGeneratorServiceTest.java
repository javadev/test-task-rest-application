package com.github.javadev.service;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringGeneratorServiceTest {

    @Test
    public void generate_list_of_maps_test() {
        String[] strings = {
            "Sound boy proceed to blast into the galaxy",
            "Go back rocket man into the sky you'll see",
            "Hear it all the time, come back rewind",
            "Aliens are watching up in the sky",
            "Sound boy process to blast into the galaxy",
            "No one gonna harm you",
            "They all want you to play I watch the birds of prey"
        };
        List<Map<String, Object>> result = new StringGeneratorService().generateListOfMaps(Arrays.asList(strings));
        assertEquals("[{string=Aliens are watching up in the sky, longestWord=8}, "
            + "{string=Sound boy proceed to blast into the galaxy, longestWord=7}, "
            + "{string=Sound boy process to blast into the galaxy, longestWord=7}, "
            + "{string=Go back rocket man into the sky you'll see, longestWord=6}, "
            + "{string=Hear it all the time, come back rewind, longestWord=6}]", result.toString());
    }
}

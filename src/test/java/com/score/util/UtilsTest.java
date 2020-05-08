package com.score.util;

import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class UtilsTest {

    @Test
    public void testReadFile() {
        Path path = FileSystems.getDefault().getPath("src/test/resources/names.txt").toAbsolutePath();
        List<String> names = Utils.readFile(path.toString());
        assertEquals(5163, names.size());
        assertSame(true, names.parallelStream().allMatch(name -> name.startsWith("\"") && name.endsWith("\"")));
    }


    @Test
    public void test_extract_DEPARTMENT_from_commandLine_args() {

        assertEquals("RISK", Utils.getDept(new String[]{"test.txt", "RISK"}));
        assertEquals("", Utils.getDept(new String[]{"test.txt", ""}));

    }
}
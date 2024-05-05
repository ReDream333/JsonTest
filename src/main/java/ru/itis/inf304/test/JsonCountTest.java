package ru.itis.inf304.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.inf304.JsonCount;
import java.io.FileNotFoundException;


public class JsonCountTest {
    @Test
    public void testRight() throws FileNotFoundException {
        //верный
        Assert.assertEquals(0, JsonCount.jsonCount("JSON.json"));
    }

    @Test
    public void testEmpty() throws FileNotFoundException {
        //пустой
        Assert.assertThrows(NullPointerException.class, () -> JsonCount.jsonCount(""));
    }

    @Test
    public void testNotExist() throws FileNotFoundException {
        //не существует
        Assert.assertThrows(FileNotFoundException.class, () -> JsonCount.jsonCount("NotExist.json"));
    }

    @Test
    public void testBynary() throws FileNotFoundException {
        //не существует
        Assert.assertThrows(RuntimeException.class, () -> JsonCount.jsonCount("Bynary.bin"));
    }
}


//        //пустой
//        try {
//            JsonCount.jsonCount("");
//            Assert.fail();
//        } catch (NullPointerException e) {
//            Assert.assertNotEquals(" ", e.getMessage());
//        }

//        //не существует
//        try {
//            JsonCount.jsonCount("NotExist.json");
//            Assert.fail();
//        } catch (FileNotFoundException e) {
//            Assert.assertNotEquals(" ", e.getMessage());
//        }
//
//        //бинарный
//        try {
//            JsonCount.jsonCount("Bynary.bin");
//            Assert.fail();
//
//        } catch (RuntimeException e) {
//            Assert.assertNotEquals(" ", e.getMessage());
//        }
//
//        try {
//            JsonCount.jsonCount("NotExist.json");
//            Assert.fail();
//        } catch (FileNotFoundException e) {
//            Assert.assertNotEquals(" ", e.getMessage());
//        }



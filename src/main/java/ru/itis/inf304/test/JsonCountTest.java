package ru.itis.inf304.test;

import org.junit.Assert;
import org.junit.Test;

import ru.itis.inf304.JsonCount;

import java.io.FileNotFoundException;


public class JsonCountTest {
    @Test
    public void testJsonCount() throws FileNotFoundException {

        Assert.assertEquals(0, JsonCount.jsonCount("JSON.json"));

        //пустой
        try {
            JsonCount.jsonCount("");
            Assert.fail();
        } catch (NullPointerException e) {
            Assert.assertNotEquals(" ", e.getMessage());
        }

        //не существует
        try {
            JsonCount.jsonCount("NotExist.json");
            Assert.fail();
        } catch (FileNotFoundException e) {
            Assert.assertNotEquals(" ", e.getMessage());
        }

        //бинарный
        try {
            JsonCount.jsonCount("Bynary.bin");
            Assert.fail();

        } catch (RuntimeException e) {
            Assert.assertNotEquals(" ", e.getMessage());
        }

    }


}


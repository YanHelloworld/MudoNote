package com.mudo.mudonote;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.mudo.utils.InputTestHelper;
import com.mudo.utils.Sysout;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testInput(){
        System.out.println(InputTestHelper.isEmail("6154@qq.com"));
    }
}
package cc.koumakan.gensokyo;

import android.app.Application;
import android.test.ApplicationTestCase;

import cc.koumakan.gensokyo.Util.ToastUtil;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    public void testToast() {
        System.out.println("testToast");
        assertEquals(0, ToastUtil.LENGTH_SHORT);
    }
}
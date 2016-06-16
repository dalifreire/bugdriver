package com.upwork.sample;

import org.junit.Assert;
import org.junit.Test;

import com.upwork.sample.Bug.DIRECTION;

/**
 * Test case for Bug.
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
public final class BugTest {

    @Test
    public void testEquals() {

        Bug b1 = new Bug(1, 0, DIRECTION.RIGHT);
        Bug b2 = new Bug(1, 1, DIRECTION.LEFT);
        Bug b3 = new Bug(2, 0, DIRECTION.RIGHT);
        Assert.assertEquals(b1, b2);
        Assert.assertNotEquals(b2, b3);
    }

}

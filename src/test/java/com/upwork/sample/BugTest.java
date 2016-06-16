package com.upwork.sample;

import java.util.UUID;

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

        String id = UUID.randomUUID().toString();
        
        Bug b1 = new Bug(id, 0, DIRECTION.RIGHT);
        Bug b2 = new Bug(id, 1, DIRECTION.LEFT);
        Bug b3 = new Bug(UUID.randomUUID().toString(), 0, DIRECTION.RIGHT);
        Assert.assertEquals(b1, b2);
        Assert.assertNotEquals(b1, b3);
    }
    
    @Test
    public void testForward_right() {
        
        int startLocation = 0;
        Bug bug = new Bug(UUID.randomUUID().toString(), startLocation, DIRECTION.RIGHT);
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
        
        bug.forward();
        Assert.assertEquals(startLocation+1, bug.getLocation());
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
        
        bug.forward();
        bug.forward();
        bug.forward();
        bug.forward();
        Assert.assertEquals(startLocation+5, bug.getLocation());
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
    }
    
    @Test
    public void testForward_left() {
        
        int startLocation = 0;
        Bug bug = new Bug(UUID.randomUUID().toString(), startLocation, DIRECTION.LEFT);
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
        
        bug.forward();
        Assert.assertEquals(startLocation-1, bug.getLocation());
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
        
        bug.forward();
        bug.forward();
        bug.forward();
        bug.forward();
        Assert.assertEquals(startLocation-5, bug.getLocation());
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
    }
    
    @Test
    public void testBackwards_right() {
        
        int startLocation = 0;
        Bug bug = new Bug(UUID.randomUUID().toString(), startLocation, DIRECTION.RIGHT);
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
        
        bug.backwards();
        Assert.assertEquals(startLocation-1, bug.getLocation());
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
        
        bug.backwards();
        bug.backwards();
        bug.backwards();
        bug.backwards();
        Assert.assertEquals(startLocation-5, bug.getLocation());
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
    }
    
    @Test
    public void testBackwards_left() {
        
        int startLocation = 0;
        Bug bug = new Bug(UUID.randomUUID().toString(), startLocation, DIRECTION.LEFT);
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
        
        bug.backwards();
        Assert.assertEquals(startLocation+1, bug.getLocation());
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
        
        bug.backwards();
        bug.backwards();
        bug.backwards();
        bug.backwards();
        Assert.assertEquals(startLocation+5, bug.getLocation());
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
    }
    
    @Test
    public void testTurnAround() {

        int startLocation = 0;
        Bug bug = new Bug(UUID.randomUUID().toString(), startLocation, DIRECTION.RIGHT);
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
        
        bug.turnAround();
        Assert.assertEquals(DIRECTION.LEFT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
        
        bug.turnAround();
        Assert.assertEquals(DIRECTION.RIGHT, bug.getDirection());
        Assert.assertEquals(startLocation, bug.getLocation());
    }

}

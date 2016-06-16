package com.upwork.sample.controller;

import org.junit.Test;
import org.mockito.Mock;

import com.upwork.sample.ui.Frame;

/**
 * Test case for FrameController.
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
public class FrameControllerTest {

    @Mock
    private Frame frame;
    
    @Test
    public void testNewBug() {
        
        FrameController frameController = new FrameController(this.frame);
        frameController.newBug();
        
    }
    
}

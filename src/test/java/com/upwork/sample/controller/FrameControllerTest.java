package com.upwork.sample.controller;

import javax.swing.JComboBox;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testNewBug() {
        
        Mockito.when(this.frame.getComboBoxBugs()).thenReturn(new JComboBox<String>());
        
        FrameController frameController = new FrameController(this.frame);
        frameController.newBug();
        
        Mockito.verify(this.frame, Mockito.times(1)).repaintBugs(Mockito.anyList());
    }
    
}

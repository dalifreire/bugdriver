package com.upwork.sample;

import java.awt.EventQueue;

import com.upwork.sample.controller.FrameController;
import com.upwork.sample.ui.Frame;

/**
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Frame frame = new Frame();
                    FrameController frameController = new FrameController(frame);
                    frameController.addEvents();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

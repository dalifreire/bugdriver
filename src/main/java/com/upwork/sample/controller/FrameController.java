package com.upwork.sample.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.upwork.sample.Bug;
import com.upwork.sample.Bug.DIRECTION;
import com.upwork.sample.ui.Frame;

/**
 * Controller for the swing frame ui.
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
public class FrameController {

    private final Logger logger = Logger.getLogger(FrameController.class.getName());
    private final Frame frame;
    private final List<Bug> bugs;

    public FrameController(Frame frame) {
        this.frame = frame;
        this.bugs = new ArrayList<Bug>();
        addEvents();
    }
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Frame frame = new Frame();
                    frame.setVisible(true);
                    
                    new FrameController(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void addEvents() {
        this.frame.getBtnNewBug().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newBug();
            }
        });
        
        this.frame.getBtnRemoveBug().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                removeBug(idBug);
            }
        });
        
        this.frame.getBtnMoveToLeft().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                moveToLeft(idBug);
            }
        });
        
        this.frame.getBtnTurnAround().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                turnAround(idBug);
            }
        });
        
        this.frame.getBtnMoveToRight().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                moveToRight(idBug);
            }
        });
    }

    /**
     * Creates a new bug.
     */
    public void newBug() {
        final Bug bug = new Bug(UUID.randomUUID().toString(), 0, DIRECTION.RIGHT);
        this.bugs.add(bug);
        this.frame.repaintBugs(this.bugs);
    }

    /**
     * Removes the selected bug.
     * 
     * @param idBug
     */
    public void removeBug(String idBug) {
        final Bug bug = bugById(idBug);
        if (bug != null) {
            if (this.bugs.contains(bug)) {
                this.bugs.remove(bug);
            }
            this.frame.repaintBugs(this.bugs);
        }
    }

    /**
     * Moves to right the selected bug.
     * 
     * @param idBug
     */
    public void moveToRight(String idBug) {
        final Bug bug = bugById(idBug);
        if (bug != null) {
            if (DIRECTION.RIGHT.equals(bug.getDirection())) {
                bug.forward();
            } else {
                bug.backwards();
            }
            this.frame.repaintBugs(this.bugs);
            
            this.logger.log(Level.INFO, String.format("Bug '%s' moved to right (%s)", idBug, bug));
        }
    }

    /**
     * Moves to left the selected bug.
     * 
     * @param idBug
     */
    public void moveToLeft(String idBug) {
        final Bug bug = bugById(idBug);
        if (bug != null) {
            if (DIRECTION.RIGHT.equals(bug.getDirection())) {
                bug.backwards();
            } else {
                bug.forward();
            }
            this.frame.repaintBugs(this.bugs);
            
            this.logger.log(Level.INFO, String.format("Bug '%s' moved to left (%s)", idBug, bug));
        }
    }

    /**
     * Reverse the bug direction.
     * 
     * @param idBug
     */
    public void turnAround(String idBug) {
        final Bug bug = bugById(idBug);
        if (bug != null) {
            bug.turnAround();
            this.frame.repaintBugs(this.bugs);
        }
    }

    /**
     * Returns the selected bug by id.
     * 
     * @param idBug
     * @return Bug
     */
    public Bug bugById(String idBug) {
        for (final Bug bug : this.bugs) {
            if (bug.getId().equals(idBug)) {
                return bug;
            }
        }
        return null;
    }

}

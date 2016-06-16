package com.upwork.sample.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

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
    private static int bugCount;

    public FrameController(Frame frame) {
        this.frame = frame;
        this.bugs = new ArrayList<Bug>();
    }
    
    public void addEvents() {
        this.frame.getBtnNewBug().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        newBug();
                    }
                });
            }
        });
        
        this.frame.getBtnRemoveBug().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                        removeBug(idBug);
                    }
                });
            }
        });
        
        this.frame.getBtnMoveToLeft().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                        moveToLeft(idBug);
                    }
                });
            }
        });
        
        this.frame.getBtnTurnAround().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                        turnAround(idBug);
                    }
                });
            }
        });
        
        this.frame.getBtnMoveToRight().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        String idBug = (String) FrameController.this.frame.getComboBoxBugs().getSelectedItem();
                        moveToRight(idBug);
                    }
                });
            }
        });
    }

    /**
     * Creates a new bug.
     */
    public void newBug() {
        final Bug bug = new Bug(String.format("Bug %s", ++bugCount), 0, DIRECTION.RIGHT);
        this.bugs.add(bug);
        this.frame.repaintBugs(this.bugs);
        this.frame.getComboBoxBugs().setSelectedItem(bug.getId());
        
        this.logger.log(Level.INFO, String.format("New bug '%s' added (%s)", bug.getId(), bug));
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
            
            this.logger.log(Level.INFO, String.format("Bug '%s' removed (%s)", bug.getId(), bug));
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
            if (DIRECTION.LEFT.equals(bug.getDirection())) {
                turnAround(idBug);
            }
            bug.forward();
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
                turnAround(idBug);
            }
            bug.forward();
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
            
            this.logger.log(Level.INFO, String.format("The bug '%s' was turned (%s)", idBug, bug));
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

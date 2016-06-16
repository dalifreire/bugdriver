package com.upwork.sample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    private final Frame frame;
    private final List<Bug> bugs;

    public FrameController(Frame frame) {
        this.frame = frame;
        this.bugs = new ArrayList<Bug>();
    }

    /**
     * Creates a new bug.
     */
    public void newBug() {
        final Bug bug = new Bug(UUID.randomUUID().toString(), 0, DIRECTION.RIGHT);
        this.bugs.add(bug);
    }

    /**
     * Removes the selected bug.
     * 
     * @param idBug
     */
    public void removeBug(String idBug) {
        final Bug bug = bugById(idBug);
        if (this.bugs.contains(bug)) {
            this.bugs.remove(bug);
        }
    }

    /**
     * Moves to right the selected bug.
     * 
     * @param idBug
     */
    public void moveToRight(String idBug) {
        final Bug bug = bugById(idBug);
        if (DIRECTION.RIGHT.equals(bug.getDirection())) {
            bug.forward();
        } else {
            bug.backwards();
        }
    }

    /**
     * Moves to left the selected bug.
     * 
     * @param idBug
     */
    public void moveToLeft(String idBug) {
        final Bug bug = bugById(idBug);
        if (DIRECTION.RIGHT.equals(bug.getDirection())) {
            bug.backwards();
        } else {
            bug.forward();
        }
    }

    /**
     * Reverse the bug direction.
     * 
     * @param idBug
     */
    public void turnAround(String idBug) {
        final Bug bug = bugById(idBug);
        bug.turnAround();
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

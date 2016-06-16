package com.upwork.sample.controller;

import java.util.ArrayList;
import java.util.List;

import com.upwork.sample.Bug;

/**
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
public class FrameController {

    private List<Bug> bugs;

    public FrameController() {
        this.bugs = new ArrayList<Bug>();
    }

    public void newBug() {

    }

    public void removeBug(int idBug) {
        Bug bug = bugById(idBug);
        if (this.bugs.contains(bug)) {
            this.bugs.remove(bug);
        }
    }

    public void moveForward(int idBug) {
        Bug bug = bugById(idBug);
        bug.forward();
    }

    public void moveBackwards(int idBug) {
        Bug bug = bugById(idBug);
        bug.backwards();
    }

    public void turnAround(int idBug) {
        Bug bug = bugById(idBug);
        bug.turnAround();
    }

    public Bug bugById(int idBug) {
        for (Bug bug : this.bugs) {
            if (idBug == bug.getId()) {
                return bug;
            }
        }
        return null;
    }

}

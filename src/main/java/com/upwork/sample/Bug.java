package com.upwork.sample;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true, of = { "direction", "location" })
public class Bug {

    @Getter
    private int id;
    @Getter
    private int location;
    @Getter
    private DIRECTION direction;

    private enum DIRECTION {
        LEFT, RIGHT
    };

    public void forward() {
        this.location = direction == DIRECTION.RIGHT ? location + 1 : location - 1;
    }

    public void backwards() {
        this.location = direction == DIRECTION.RIGHT ? location - 1 : location + 1;
    }

    public void turnAround() {
        if (this.direction == DIRECTION.RIGHT) {
            this.direction = DIRECTION.LEFT;
        } else {
            this.direction = DIRECTION.RIGHT;
        }
    }

}

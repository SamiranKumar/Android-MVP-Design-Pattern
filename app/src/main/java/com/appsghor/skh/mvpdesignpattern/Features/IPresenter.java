package com.appsghor.skh.mvpdesignpattern.Features;

import java.util.UUID;

/**
 * Created by SKH PC on 5/24/2017.
 */

public interface IPresenter {
    /***
     * setScreen method is used to the view reference in the presanter
     * and after an orientation change
     * @param screen
     */
    void setScreen(IScreen screen);

    /***
     * The getUUID method is used to save and restore
     * the Presenter instances during an orientation changes
     */
    UUID getUuid();
}

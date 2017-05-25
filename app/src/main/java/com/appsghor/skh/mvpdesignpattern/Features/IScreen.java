package com.appsghor.skh.mvpdesignpattern.Features;

import java.util.UUID;

/**
 * Created by SKH PC on 5/24/2017.
 */

/***
 Common screen interface.
 *
 * The purpose of this interface is to facilitate
 * the creation of the {@link IPresenter} interface's
 * {@link IPresenter #setScreen(IScreen)} method.
 */
public interface IScreen {
    void cachepresanter(IPresenter presenter);
    void restorePresanter(UUID uuid);
}

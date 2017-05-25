package com.appsghor.skh.mvpdesignpattern.Features.FeatureM.View;

import com.appsghor.skh.mvpdesignpattern.Features.IScreen;

/**
 * Created by Acer on 5/25/2017.
 */

public interface IFoodView extends IScreen {
    void requestAction1();
    void postResult1(String result);

    void requestAction2();
    void postResult2(String result);

    void requestAction3();
    void postResult3(String result);

    void requestAction4();
    void postResult4(String result);
}

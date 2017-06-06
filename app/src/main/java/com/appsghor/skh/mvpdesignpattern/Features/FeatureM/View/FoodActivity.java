package com.appsghor.skh.mvpdesignpattern.Features.FeatureM.View;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.appsghor.skh.mvpdesignpattern.Cache.Cache;
import com.appsghor.skh.mvpdesignpattern.Common.ILogName;
import com.appsghor.skh.mvpdesignpattern.Common.LogUtility;
import com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Model.Food;
import com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Presenter.FoodPresanter;
import com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Presenter.IFoodPresenter;
import com.appsghor.skh.mvpdesignpattern.Features.IPresenter;
import com.appsghor.skh.mvpdesignpattern.R;

import java.util.List;
import java.util.UUID;

public class FoodActivity extends AppCompatActivity implements IFoodView,ILogName{


    private final static String TAG_PRESENTER = "PRESENTER";
    private final static String TAG_VIEW_1 = "VIEW 1";
    private final static String TAG_VIEW_2 = "VIEW 2";
    private final static String TAG_VIEW_3 = "VIEW 3";
  //  private final static String TAG_VIEW_4 = "VIEW 4";

    private TextView TVFoof1;
    private TextView TVFoof2;
    private TextView TVFoof3;


    private IFoodPresenter foodPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printLog(" In onCreate()");
        TVFoof1 = (TextView) findViewById(R.id.tv_food_1);
        TVFoof2 = (TextView) findViewById(R.id.tv_food_2);
        TVFoof3 = (TextView) findViewById(R.id.tv_food_3);


        foodPresenter = new FoodPresanter(this);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        printLog(" In onSaveInstanceState()");
        outState.putString(TAG_VIEW_1, TVFoof1.getText().toString());
        outState.putString(TAG_VIEW_2, TVFoof2.getText().toString());
        outState.putString(TAG_VIEW_3, TVFoof3.getText().toString());


        //Restore Presenter Instances
        outState.putString(TAG_PRESENTER, foodPresenter.getUuid().toString());
        cachepresanter(foodPresenter);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        printLog(" In onRestoreInstanceState()");
        TVFoof1.setText(savedInstanceState.getString(TAG_VIEW_1));
        TVFoof2.setText(savedInstanceState.getString(TAG_VIEW_2));
        TVFoof3.setText(savedInstanceState.getString(TAG_VIEW_3));

        restorePresanter(UUID.fromString(savedInstanceState.getString(TAG_PRESENTER)));

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        printLog(" In onResume()");
        this.requestAction1();
        this.requestAction2();
        this.requestAction3();
        this.requestAction4();
    }

    @Override
    public void requestAction1() {

        printLog(" In requestAction1()");
        foodPresenter.RequastAction1();
    }

    @Override
    public void postResult1(String result) {
        printLog(" In postResult1()");
        TVFoof1.setText(result);
    }

    @Override
    public void requestAction2() {
        printLog(" In requestAction2()");
        foodPresenter.RequastAction2();
    }

    @Override
    public void postResult2(String result) {
        printLog(" In postResult2()");
        TVFoof2.setText(result);
    }

    @Override
    public void requestAction3() {
        printLog(" In requestAction3()");
        foodPresenter.RequastAction3();
    }

    @Override
    public void postResult3(String result) {
        printLog(" In postResult3()");
        TVFoof3.setText(result.toString());
    }

    @Override
    public void requestAction4() {
        printLog(" In requestAction4()");
        foodPresenter.RequastAction4();
    }

    @Override
    public void postResult4(List<Food> result) {
        printLog(" In postResult4()");
       // TVFoof4.setText(result);
    }

    @Override
    public void cachepresanter(IPresenter presenter) {
        printLog(" In cachepresanter()");
        Cache.getCacheInstances().cachePresenterFor(presenter.getUuid(), presenter);
    }

    @Override
    public void restorePresanter(UUID uuid) {
        printLog(" In restorePresanter()");
        foodPresenter = (IFoodPresenter) Cache.getCacheInstances().restorePresenter(uuid);

        foodPresenter.setScreen(this);
    }

    @Override
    public String getLogName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void printLog(String message) {
        LogUtility.printMessage("["+getLogName()+"] : " + message);
    }
}

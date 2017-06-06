package com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Presenter;

import android.os.AsyncTask;

import com.appsghor.skh.mvpdesignpattern.Common.ILogName;
import com.appsghor.skh.mvpdesignpattern.Common.LogUtility;
import com.appsghor.skh.mvpdesignpattern.Common.Util;
import com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Model.Food;
import com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Model.FoodModel;
import com.appsghor.skh.mvpdesignpattern.Features.FeatureM.View.IFoodView;
import com.appsghor.skh.mvpdesignpattern.Features.IScreen;

import java.util.List;
import java.util.UUID;

/**
 * Created by Acer on 5/25/2017.
 */

public class FoodPresanter implements IFoodPresenter,ILogName {

    private UUID uuid;
    private IFoodView foodView;
    private FoodModel foodModel;

    public FoodPresanter(IFoodView iFoodView) {
        this.uuid = UUID.randomUUID();
        this.foodView = iFoodView;
        this.foodModel = new FoodModel();
    }

    @Override
    public void RequastAction1() {

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                Util.simulateNetworkLatency(2000);
                return foodModel.requestAction1();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                foodView.postResult1(s);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void RequastAction2() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                Util.simulateNetworkLatency(2000);
                return foodModel.requestAction2();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                foodView.postResult2(s);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void RequastAction3() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                Util.simulateNetworkLatency(2000);
                return foodModel.requestAction3();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                foodView.postResult3(s);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void RequastAction4() {
        new AsyncTask<Void, Void, List<Food>>() {
            @Override
            protected List<Food> doInBackground(Void... params) {
                Util.simulateNetworkLatency(2000);
                return foodModel.requestAction4();

            }

            @Override
            protected void onPostExecute(List<Food> s) {
                super.onPostExecute(s);
                foodView.postResult4(s);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void setScreen(IScreen screen) {
        this.foodView = (IFoodView) screen;
    }

    @Override
    public UUID getUuid() {
        printLog(new Object(){}.getClass().getEnclosingMethod().toString());
        return uuid;
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

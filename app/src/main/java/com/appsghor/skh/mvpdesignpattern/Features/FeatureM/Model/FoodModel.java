package com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SKH PC on 5/24/2017.
 */

public class FoodModel {
    public String requestAction1(){
        //compute some data here
        return "Response One";
    }

    public String requestAction2(){
        //compute some data here
        return "Response Two";
    }


    public String requestAction3(){
        //compute some data here
        return "Response Three";
    }

    public List<Food> requestAction4(){
        //compute some data here

        List<Food> foodList = new ArrayList<>();
        Food food = new Food();
        for(int i=0;i<10;i++){

            Random random = new Random();
            int n = random.nextInt(10) +1;
           // random.nextInt(10) + 1;
            food.setId(i+1);
            food.setName("Food :"+n);
            food.setDescriptiom("Food Description.................. "+i);

            foodList.add(food);

        }


        return foodList;
    }
}

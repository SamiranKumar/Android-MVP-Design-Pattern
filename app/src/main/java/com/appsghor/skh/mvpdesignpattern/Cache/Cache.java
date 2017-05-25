package com.appsghor.skh.mvpdesignpattern.Cache;

import com.appsghor.skh.mvpdesignpattern.Features.Presenter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by SKH PC on 5/24/2017.
 */

public class Cache implements Serializable{

    private  static Cache mCacheInstances;
    private Map<UUID,Presenter> mCaches;

    public static Cache getCacheInstances(){
        if(mCacheInstances == null){
            mCacheInstances = new Cache();
        }
        return mCacheInstances;

    }

    private Cache(){
        mCaches = new HashMap<UUID, Presenter>() ;

    }


    public  void cachePresenterFor(UUID uuid , Presenter presenter){
        mCaches.put(uuid,presenter);
    }

    public Presenter restorePresenter(UUID uuid){
        Presenter mPresenter = mCaches.get(uuid);
        mCaches.remove(mPresenter);
        return mPresenter;
    }
}

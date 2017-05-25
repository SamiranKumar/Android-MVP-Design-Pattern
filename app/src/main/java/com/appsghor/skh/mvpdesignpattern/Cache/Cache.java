package com.appsghor.skh.mvpdesignpattern.Cache;

import com.appsghor.skh.mvpdesignpattern.Features.IPresenter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by SKH PC on 5/24/2017.
 */

public class Cache implements Serializable {

    private static Cache mCacheInstances;
    private Map<UUID, IPresenter> mCaches;

    public static Cache getCacheInstances() {
        if (mCacheInstances == null) {
            mCacheInstances = new Cache();
        }
        return mCacheInstances;

    }

    private Cache() {
        mCaches = new HashMap<UUID, IPresenter>();

    }


    public void cachePresenterFor(UUID uuid, IPresenter IPresenter) {
        mCaches.put(uuid, IPresenter);
    }

    public IPresenter restorePresenter(UUID uuid) {
        IPresenter mIPresenter = mCaches.get(uuid);
        mCaches.remove(mIPresenter);
        return mIPresenter;
    }
}

package com.pokercc.appinjector;

import android.app.Application;

/**
 * Created by cisco on 2017/11/20.
 */
@Deprecated
public interface IAppInjector {

    void onAppCreate(Application app, String[] args);
}

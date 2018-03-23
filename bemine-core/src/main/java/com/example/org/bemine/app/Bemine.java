package com.example.org.bemine.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by xjc-pc on 2018/3/23.
 */

public final class Bemine {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),
                context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getBemineConfigs();
    }
}

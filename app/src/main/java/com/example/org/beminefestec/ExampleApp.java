package com.example.org.beminefestec;

import android.app.Application;

import com.example.org.bemine.app.Bemine;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by xjc-pc on 2018/3/23.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bemine.init(this)
                .withIcon(new FontAwesomeModule())
                .configure();
    }
}

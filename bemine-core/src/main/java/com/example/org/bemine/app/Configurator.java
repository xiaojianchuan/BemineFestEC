package com.example.org.bemine.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xjc-pc on 2018/3/23.
 * 配置文件存储级获取
 */

public class Configurator {

    //存储配置项
    private static final HashMap<String, Object> BEMINE_CONFIGS
            = new HashMap<>();
    //存储字体图标
    private static final ArrayList<IconFontDescriptor> ICONS
            = new ArrayList<>();

    private Configurator(){
        BEMINE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    final HashMap<String, Object> getBemineConfigs(){
        return BEMINE_CONFIGS;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    public final void configure(){
        initIcons();
        BEMINE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host){
        BEMINE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    //字体图标
    private void initIcons(){
        if (ICONS.size() > 0){
            final Iconify.IconifyInitializer initializer
                    = Iconify.with(ICONS.get(0));
            for (int i=1; i<ICONS.size(); i++){
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) BEMINE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("配置文件还没有准备好,请检查配置文件");
        }
    }

    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) BEMINE_CONFIGS.get(key.name());
    }
}

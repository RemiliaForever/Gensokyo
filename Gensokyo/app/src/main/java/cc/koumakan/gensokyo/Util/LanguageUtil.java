package cc.koumakan.gensokyo.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Create by Remilia Scarlet
 * at 2015/10/30 12:16
 * <p/>
 * 更改app语言，提供init()，get()，set()方法
 * 存储为Sharepreference的Language文件
 **/
@SuppressWarnings("unused")
public class LanguageUtil {
    public static Locale CHINESE = Locale.CHINESE;
    public static Locale JAPENESE = Locale.JAPANESE;

    public static void init(Context context, Resources resources) {
        change(resources, load(context));
    }

    public static String get(Resources resources) {
        Configuration config = resources.getConfiguration();
        return config.locale.getLanguage();
    }

    public static String set(Context context, Resources resources) {
        return save(context, resources.getConfiguration().locale);
    }

    public static void change(Resources resources, Locale string) {
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        config.locale = string;
        resources.updateConfiguration(config, dm);
    }

    private static Locale load(Context context) {
        SharedPreferences sp = context.getSharedPreferences("Lauguage", Context.MODE_PRIVATE);
        return new Locale(sp.getString("Lauguage", "zh"));
    }

    private static String save(Context context, Locale locale) {
        SharedPreferences sp = context.getSharedPreferences("Lauguage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Lauguage", locale.getLanguage());
        editor.apply();
        return locale.getLanguage();
    }
}

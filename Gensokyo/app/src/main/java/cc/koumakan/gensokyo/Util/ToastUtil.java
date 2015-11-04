package cc.koumakan.gensokyo.Util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cc.koumakan.gensokyo.R;

/**
 * Create by Remilia Scarlet
 * at 2015/10/29 15:29
 * <p/>
 * 用于显示自定义Toast，提供show()和hide()方法
 * 不会产生队列，后一个将直接隐藏前一个Toast
 **/
@SuppressWarnings("unused")
public class ToastUtil {
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    private static Toast toast = null;

    public static void show(Context context, String string, int time) {
        if (null == toast) newToast(context, string, time);
        else {
            hide();
            newToast(context, string, time);
        }
    }

    public static void show(Context context, String string) {
        show(context, string, LENGTH_SHORT);
    }

    public static void hide() {
        if (null != toast) toast.cancel();
        toast = null;
    }

    private static void newToast(Context context, String string, int time) {
        toast = new Toast(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.toast, null);
        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        textView.setText(string);
        toast.setGravity(Gravity.BOTTOM, 0, 200);
        toast.setDuration(time);
        toast.setView(layout);
        toast.show();
    }

}

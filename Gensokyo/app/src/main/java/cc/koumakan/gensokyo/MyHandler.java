package cc.koumakan.gensokyo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.List;

/**
 * Create by Remilia Scarlet
 * at 2015/11/4 11:19
 **/
public class MyHandler {
    public Handler opengl_debug;
    private MainActivity context;

    public MyHandler(Context context) {
        opengl_debug = new OpenGL_DEBUG();
        this.context = (MainActivity) context;
    }


    class OpenGL_DEBUG extends Handler {
        @Override
        public void handleMessage(Message msg) {
            List<String> map = (List<String>) msg.obj;
            String all;
            try {
                TextView textView = (TextView) context.findViewById(R.id.opengl_debug_info);
                all = "";
                for (String s : map) {
                    all += s;
                }
                textView.setText(all);
            } catch (Exception e) {

            }
        }
    }
}

package cc.koumakan.gensokyo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Map;

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
            Map<String, String> map = (Map<String, String>) msg.obj;
            try {
                TextView textView = (TextView) context.findViewById(R.id.opengl_debug_fps);
                textView.setText(map.get("fps"));
                textView = (TextView) context.findViewById(R.id.opengl_debug_vertex);
                textView.setText(map.get("vertex"));
                textView = (TextView) context.findViewById(R.id.opengl_debug_triangle);
                textView.setText(map.get("triangle"));
            } catch (Exception e) {

            }
        }
    }
}

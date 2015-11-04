package cc.koumakan.gensokyo.OpenGL;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.koumakan.gensokyo.MainActivity;
import cc.koumakan.gensokyo.OpenGL.Entity.Cube;
import cc.koumakan.gensokyo.OpenGL.Entity.TestMesh;
import cc.koumakan.gensokyo.R;

/**
 * Create by Remilia Scarlet
 * at 2015/10/30 18:36
 **/
public class MainView extends GLSurfaceView {
    private MyRenderer myRenderer;
    private Camera camera;
    private List list;

    public MainView(Context context) {
        super(context);
        camera = new Camera();
        list = new ArrayList();
        list.add(new TestMesh());
        list.add(new Cube());
        myRenderer = new MyRenderer(context, camera, list);
        this.setRenderer(myRenderer);
    }


    public void openDebug(final Handler handler) {
        Thread debug = new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> map = new HashMap<>();
                while (true) {
                    Message message = new Message();
                    message.obj = map;
                    map.put("fps", "FPS:" + myRenderer.frame * 2);
                    map.put("vertex","VERTEX:" + myRenderer.vertex);
                    map.put("triangle","TRIANGLE:" + myRenderer.triangle);
                    myRenderer.frame = 0;
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        map.clear();
                        map.put("fps", "Debug Tread Interrupted!");
                    }
                    handler.sendMessage(message);
                }
            }
        });
        debug.start();
    }
}

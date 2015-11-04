package cc.koumakan.gensokyo.OpenGL;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import cc.koumakan.gensokyo.OpenGL.Entity.Cube;
import cc.koumakan.gensokyo.OpenGL.Entity.TestMesh;

import static java.lang.Math.sqrt;

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
                List<String> map = new ArrayList<>();
                while (true) {
                    Message message = new Message();
                    message.obj = map;
                    map.clear();
                    map.add("FPS:" + myRenderer.frame * 2 + "\n");
                    map.add("VERTEX:" + myRenderer.vertex + "\n");
                    map.add("TRIANGLE:" + myRenderer.triangle + "\n");
                    map.add("LOCATION:" + camera.eye.toString() + "\n");
                    map.add("ANGLE:" + camera.getAngle());
                    handler.sendMessage(message);
                    myRenderer.frame = 0;
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        map.clear();
                        map.add("Debug Tread Interrupted!");
                        handler.sendMessage(message);
                    }
                }
            }
        });
        debug.start();
    }

    float x = 0;
    float y = 0;
    float oldfar = 0;

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        float far = 0;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        if (event.getPointerCount() == 1) {
            x1 = (int) event.getX();
            y1 = (int) event.getY();
        } else if (event.getPointerCount() == 2) {
            x1 = (int) event.getX(0);
            x2 = (int) event.getX(1);
            y1 = (int) event.getY(0);
            y2 = (int) event.getY(1);
            far = (float) sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_POINTER_UP:
                x = x1;
                y = y1;
                oldfar = 0;
                break;
            case MotionEvent.ACTION_UP:
                x = 0;
                y = 0;
                oldfar = 0;
                break;
            case MotionEvent.ACTION_DOWN:
                x = x1;
                y = y1;
                oldfar = 0;
            case MotionEvent.ACTION_POINTER_DOWN:
                x = 0;
                y = 0;
                oldfar = far;
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() == 1) {
                    if (x != 0 || y != 0) {
                        camera.turn(x - x1, camera.LEFT);
                        camera.turn(y - y1, camera.UP);
                    }
                    x = x1;
                    y = y1;
                } else if (event.getPointerCount() == 2) {
                    if (oldfar != 0)camera.move (oldfar - far,0);
                    oldfar = far;
                }
                break;
        }
        return true;
    }
}

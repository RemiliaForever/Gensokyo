//package cc.koumakan.gensokyo.back;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.opengl.GLSurfaceView.Renderer;
//import android.opengl.GLU;
//import android.opengl.GLUtils;
//
//import javax.microedition.khronos.egl.EGLConfig;
//import javax.microedition.khronos.opengles.GL10;
//
//import cc.koumakan.gensokyo.R;
//
//
//public class MyRenderer implements Renderer {
//    Location location;
//    Context context;
//
//    public MyRenderer(Viriable vi) {
//        location = vi.location;
//        context = vi.context;
//    }
//
//    @Override
//    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
//        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
//        gl.glShadeModel(GL10.GL_SMOOTH);
//        gl.glEnable(GL10.GL_DEPTH_TEST);
//        gl.glClearDepthf(1.0f);
//        gl.glDepthFunc(GL10.GL_LEQUAL);
//        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
//        gl.glDisable(GL10.GL_DITHER);
//        loadtexture(context, gl);
//    }
//
//    @Override
//    public void onDrawFrame(GL10 gl) {
//        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
//        gl.glLoadIdentity();
//        gl.glFrontFace(GL10.GL_CCW);
//        gl.glTranslatef(0, 0, -location.distance);
//        gl.glRotatef(location.dp, 1, 0, 0);
//        gl.glRotatef(location.sp, 0, 1, 0);
//    }
//
//    @Override
//    public void onSurfaceChanged(GL10 gl, int width, int height) {
//        gl.glViewport(0, 0, width, height);
//        gl.glMatrixMode(GL10.GL_PROJECTION);
//        gl.glLoadIdentity();
//        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.0001f, 300.0f);
//        gl.glMatrixMode(GL10.GL_MODELVIEW);
//        gl.glLoadIdentity();
//    }
//
//    public void loadtexture(Context context, GL10 gl) {
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.app_icon);
//        int[] textures = new int[1];
//        gl.glGenTextures(1, textures, 0);
//        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
//        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
//        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
//        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
//        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);
//        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
//        bitmap.recycle();
//    }
//}
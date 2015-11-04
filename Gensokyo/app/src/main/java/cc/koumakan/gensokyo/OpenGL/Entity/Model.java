package cc.koumakan.gensokyo.OpenGL.Entity;

import android.content.Context;

import javax.microedition.khronos.opengles.GL10;

/**
 * Create by Remilia Scarlet
 * at 2015/11/3 20:39
 **/
public interface Model {
    void loadTexture(GL10 gl, Context context);
    int getVertext();
    int getTriangle();
    void draw(GL10 gl);
}

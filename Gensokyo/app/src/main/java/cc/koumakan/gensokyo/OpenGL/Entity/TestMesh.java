package cc.koumakan.gensokyo.OpenGL.Entity;

import android.content.Context;

import javax.microedition.khronos.opengles.GL10;

/**
 * Create by Remilia Scarlet
 * at 2015/11/3 18:11
 **/
public class TestMesh implements Model {
    private float vertices[] = {
            -1.0f, 1.0f, 0.0f, // 0, Top Left
            -1.0f, -1.0f, 0.0f, // 1, Bottom Left
            1.0f, -1.0f, 0.0f, // 2, Bottom Right
            1.0f, 1.0f, 0.0f // 3, Top Right
    };
    private short[] indices = {
            0, 1, 2,
            0, 2, 3
    };
    private float[] colors = {
            1, 0, 0, 1,
            0, 1, 0, 1,
            0, 0, 1, 1,
            0, 0, 0, 0
    };
    private float vertices2[] = {
            0.0f, 0.0f, 0.0f,
            5.0f, 0.0f, 0.0f,
            0.0f, 5.0f, 0.0f,
            0.0f, 0.0f, 5.0f
    };
    private short[] indices2 = {
            0, 1, 0,
            2, 0, 3
    };
    private float[] colors2 = {
            0, 0, 0, 1,
            1, 1, 1, 1,
            1, 0, 0, 1,
            1, 1, 1, 1
    };
    private float vertices3[] = {
            -1.0f, 1.0f, 1.0f, // 0, Top Left
            -1.0f, -1.0f, 1.0f, // 1, Bottom Left
            1.0f, -1.0f, 1.0f, // 2, Bottom Right
            1.0f, 1.0f, 1.0f // 3, Top Right
    };
    private short[] indices3 = {
            0, 1, 2,
            0, 2, 3,
            0, 2, 1,
            0, 3, 2
    };
    Mesh body = new Mesh(vertices, indices, colors);
    Mesh xyz = new Mesh(vertices2, indices2, colors2);
    Mesh car = new Mesh(vertices3, indices3, colors);

    @Override
    public void loadTexture(GL10 gl, Context context) {
    }

    @Override
    public int getVertext() {
        return body.vertices.length / 3 + car.vertices.length / 3 + xyz.vertices.length / 3;
    }

    @Override
    public int getTriangle() {
        return body.indices.length / 3 + car.indices.length / 3 + xyz.indices.length / 2;
    }

    @Override
    public void draw(GL10 gl) {
        body.draw(gl);
        xyz.setkind(GL10.GL_LINES);
        xyz.draw(gl);
        car.draw(gl);
    }
}

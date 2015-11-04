package cc.koumakan.gensokyo.OpenGL;

import android.opengl.GLU;

import javax.microedition.khronos.opengles.GL10;

/**
 * Create by Remilia Scarlet
 * at 2015/11/2 21:05
 **/
@SuppressWarnings("unused")
public class Camera {
    public final int UP = 0;
    public final int DOWN = 1;
    public final int LEFT = 2;
    public final int RIGHT = 3;
    public final int FRONT = 4;
    public final int BEHIND = 5;

    class point {
        float x;
        float y;
        float z;

        public point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    point eye;
    point center;
    point up;


    public Camera() {
        eye = new point(1, 1, 5);
        center = new point(0, 0, 0);
        up = new point(0, 1, 0);
    }

    public void change(GL10 gl) {
        GLU.gluLookAt(gl, eye.x, eye.y, eye.z, center.x, center.y, center.z, up.x, up.y, up.z);
    }

    public void turn(float angle, int direction) {
        switch (direction) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
            default:
                break;
        }
    }

    public void move(float length, int direction) {
        switch (direction) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
            case FRONT:
            case BEHIND:
            default:
                break;
        }
    }
}

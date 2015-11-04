package cc.koumakan.gensokyo.OpenGL;

import android.opengl.GLU;

import java.text.DecimalFormat;

import javax.microedition.khronos.opengles.GL10;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

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

    public int turn_speed = 500;

    DecimalFormat df = new DecimalFormat("0.00");

    class point {
        float x;
        float y;
        float z;

        public point(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return df.format(x) + "," + df.format(y) + "," + df.format(z);
        }
    }

    point eye;
    point center;
    float horizontal_angle;
    float vertical_angle;

    public String getAngle() {
        return (short) (180 * horizontal_angle / Math.PI) + "," + (short) (180 * vertical_angle / Math.PI);
    }

    public Camera() {
        eye = new point(0f, 0f, 3f);
        center = new point(0f, 0f, 0f);
        horizontal_angle = 0f;
        vertical_angle = 0f;
    }

    public void change(GL10 gl) {
        center.x = eye.x + (float) (cos(vertical_angle) * sin(horizontal_angle));
        center.y = eye.y + (float) (sin(vertical_angle));
        center.z = eye.z - (float) (cos(vertical_angle) * cos(horizontal_angle));
        GLU.gluLookAt(gl, eye.x, eye.y, eye.z, center.x, center.y, center.z, 0f, 1f, 0f);
    }

    public void turn(float angle, int direction) {
        angle = angle / 500;
        switch (direction) {
            case UP:
                vertical_angle += angle;
                break;
            case DOWN:
                vertical_angle -= angle;
                break;
            case LEFT:
                horizontal_angle -= angle;
                break;
            case RIGHT:
                horizontal_angle += angle;
                break;
            default:
                break;
        }
        if (vertical_angle > Math.PI / 2) vertical_angle = (float) Math.PI / 2;
        else if (vertical_angle < -Math.PI / 2) vertical_angle = (float) -Math.PI / 2;
        if (horizontal_angle > 2 * Math.PI) horizontal_angle -= 2 * Math.PI;
        else if (horizontal_angle < -2 * Math.PI) horizontal_angle += 2 * Math.PI;
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

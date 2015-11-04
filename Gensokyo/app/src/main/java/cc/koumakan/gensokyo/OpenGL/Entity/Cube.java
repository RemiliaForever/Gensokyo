package cc.koumakan.gensokyo.OpenGL.Entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Create by Remilia Scarlet
 * at 2015/10/30 19:00
 **/
public class Cube implements Model {
    private FloatBuffer vertexBuffer;    // 顶点数组缓冲区
    private FloatBuffer texBuffer;        // 纹理坐标数据缓冲区
    private float[] vertices = { // 定义一个面的顶点坐标
            -1.0f, -1.0f, 0.0f,  // 0. 左-底-前
            1.0f, -1.0f, 0.0f,   // 1. 右-底-前
            -1.0f, 1.0f, 0.0f,  // 2. 左-顶-前
            1.0f, 1.0f, 0.0f    // 3. 右-顶-前
    };

    float[] texCoords = { // 定义上面的面的纹理坐标
            0.0f, 1.0f,  // A. 左-下
            1.0f, 1.0f,  // B. 右-下
            0.0f, 0.0f,  // C. 左-上
            1.0f, 0.0f   // D. 右-上
    };

    int[] textureIDs = new int[1]; // 纹理-ID数组

    // 构造函数，设置缓冲区
    public Cube() {
        // 设置顶点数组，顶点数据为浮点数据类型。一个浮点类型的数据长度为四个字节
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // 使用原生字节顺序
        vertexBuffer = vbb.asFloatBuffer(); // 将字节类型缓冲区转换成浮点类型
        vertexBuffer.put(vertices);         // 将数据复制进缓冲区
        vertexBuffer.position(0);           // 定位到初始位置

        // 设置纹理坐标数组缓冲区，数据类型为浮点数据
        ByteBuffer tbb = ByteBuffer.allocateDirect(texCoords.length * 4);
        tbb.order(ByteOrder.nativeOrder());
        texBuffer = tbb.asFloatBuffer();
        texBuffer.put(texCoords);
        texBuffer.position(0);

    }

    @Override
    public void loadTexture(GL10 gl, Context context) {
        gl.glGenTextures(1, textureIDs, 0); // 生成纹理ID数组
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[0]);    // 绑定到纹理ID

        // 设置纹理过滤方式
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

        InputStream ins = null;
        Bitmap bmp;
        try {
            ins = context.getResources().getAssets().open("texture.png");// 构造一个输入流来加载纹理文件
            bmp = BitmapFactory.decodeStream(ins);// 读取并将输入流解码成位图
            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bmp, 0);// 根据加载的位图为当前绑定的纹理ID建立纹理
            bmp.recycle();
        } catch (IOException e) {
            Log.e("Remilia", e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ins.close();
            } catch (IOException e) {
                Log.e("Remilia", e.getMessage());
                e.printStackTrace();
            }
        }
    }
    @Override
    public int getVertext() {
        return vertices.length / 3;
    }

    @Override
    public int getTriangle() {
        return 2;
    }
    @Override
    // 绘图
    public void draw(GL10 gl) {
        gl.glEnable(GL10.GL_TEXTURE_2D);//启用2D纹理
        //gl.glEnable(GL10.GL_BLEND);//启用纹理混合
        //gl.glBlendFunc(GL10.GL_ONE, GL10.GL_SRC_COLOR);//指定纹理混合函数

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);//打开管道
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);  // 使能纹理坐标数组
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texBuffer); // 定义纹理坐标数组缓冲区

        // 前
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // 恢复原来的状态
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_TEXTURE_2D);
    }
}

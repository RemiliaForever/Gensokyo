//package cc.koumakan.gensokyo.back;
//
//import java.nio.ByteBuffer;
//import java.nio.ByteOrder;
//import java.nio.FloatBuffer;
//import java.nio.ShortBuffer;
//
//import javax.microedition.khronos.opengles.GL10;
//
//public class Mesh {
//    private float[] vertices;
//    private short[] indices;
//    private float[] colors;
//    private float[] uvertices;
//    private FloatBuffer vertexBuffer;
//    private FloatBuffer colorBuffer;
//    private ShortBuffer indexBuffer;
//    private FloatBuffer textureBuffer;
//    private int kind = GL10.GL_TRIANGLES;
//
//    public Mesh(float invertices[], short inindices[], float incolors[]) {
//        vertices = invertices.clone();
//        indices = inindices.clone();
//        colors = incolors.clone();
//
//        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
//        vbb.order(ByteOrder.nativeOrder());
//        vertexBuffer = vbb.asFloatBuffer();
//        vertexBuffer.put(vertices);
//        vertexBuffer.position(0);
//
//        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
//        cbb.order(ByteOrder.nativeOrder());
//        colorBuffer = cbb.asFloatBuffer();
//        colorBuffer.put(colors);
//        colorBuffer.position(0);
//
//        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
//        ibb.order(ByteOrder.nativeOrder());
//        indexBuffer = ibb.asShortBuffer();
//        indexBuffer.put(indices);
//        indexBuffer.position(0);
//    }
//
//    public Mesh(float invertices[], short inindices[], float intexture[], int i) {
//        vertices = invertices.clone();
//        indices = inindices.clone();
//        uvertices = intexture.clone();
//
//        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
//        vbb.order(ByteOrder.nativeOrder());
//        vertexBuffer = vbb.asFloatBuffer();
//        vertexBuffer.put(vertices);
//        vertexBuffer.position(0);
//
//        ByteBuffer cbb = ByteBuffer.allocateDirect(uvertices.length * 4);
//        cbb.order(ByteOrder.nativeOrder());
//        textureBuffer = cbb.asFloatBuffer();
//        textureBuffer.put(uvertices);
//        textureBuffer.position(0);
//
//        ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
//        ibb.order(ByteOrder.nativeOrder());
//        indexBuffer = ibb.asShortBuffer();
//        indexBuffer.put(indices);
//        indexBuffer.position(0);
//
//    }
//
//    public void setkind(int k) {
//        kind = k;
//    }
//
//    public void draw(GL10 gl) {
//        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
//        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
//        gl.glDrawElements(kind, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
//        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
//        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//    }
//
//    public void draw(GL10 gl, int textureid) {
//        gl.glEnable(GL10.GL_CULL_FACE);
//        gl.glEnable(GL10.GL_TEXTURE_2D);
//        gl.glEnable(GL10.GL_VERTEX_ARRAY);
//        gl.glEnable(GL10.GL_TEXTURE_COORD_ARRAY);
//        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
//        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
//        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureid);
//        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
//        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
//    }
//}

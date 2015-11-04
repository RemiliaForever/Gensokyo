package cc.koumakan.gensokyo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cc.koumakan.gensokyo.OpenGL.MainView;
import cc.koumakan.gensokyo.Util.LanguageUtil;
import cc.koumakan.gensokyo.Util.ToastUtil;

/**
 * Create by Remilia Scarlet
 * at 2015/10/29 15:28
 **/
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LanguageUtil.init(this, getResources());

        RelativeLayout v = (RelativeLayout) getLayoutInflater().inflate(R.layout.main_activity, null);
        v.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(MainActivity.this, getString(R.string.test));
            }
        });
        setContentView(v);

        final MainView mainView = new MainView(MainActivity.this);
        final RelativeLayout rl = (RelativeLayout) getLayoutInflater().inflate(R.layout.opengl_debug, null);
        rl.addView(mainView);
        final MyHandler myHandler = new MyHandler(this);

        Button btn = (Button) findViewById(R.id.beginbutton);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mainView.openDebug(myHandler.opengl_debug);
                rl.findViewById(R.id.opengl_debug_fps).bringToFront();
                rl.findViewById(R.id.opengl_debug_vertex).bringToFront();
                rl.findViewById(R.id.opengl_debug_triangle).bringToFront();
                setContentView(rl);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        ToastUtil.hide();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}

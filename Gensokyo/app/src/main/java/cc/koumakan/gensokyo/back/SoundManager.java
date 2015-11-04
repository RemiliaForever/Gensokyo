//package cc.koumakan.gensokyo.back;
//
//import android.content.Context;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.media.SoundPool;
//
//import cc.koumakan.gensokyo.R;
//
//public class SoundManager {
//    public MediaPlayer mediaplayer;
//    public SoundPool soundpool;
//
//    public SoundManager(Context c) {
//        mediaplayer = MediaPlayer.create(c, R.raw.saber);
//        mediaplayer.setLooping(true);
//        mediaplayer.start();
//        soundpool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
//        soundpool.load(c, R.raw.hello, 1);
//        soundpool.load(c, R.raw.smile, 2);
//        soundpool.load(c, R.raw.no, 3);
//        soundpool.load(c, R.raw.angry, 4);
//        soundpool.load(c, R.raw.sad, 5);
//    }
//
//    float index = 1;
//
//    public void playsound() {
//        soundpool.play((int) index, index / 5, 1 - index / 5, 0, 0, 1);
//        index++;
//        if (index > 5) index = 1;
//    }
//}

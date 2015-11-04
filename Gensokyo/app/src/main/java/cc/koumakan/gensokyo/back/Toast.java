//package cc.koumakan.gensokyo.back;
//
//import android.content.Context;
//
//public class Toast {
//
//    static long timer_short = System.currentTimeMillis();//避免短时间重复调用
//
//    public static void dis_short(String s) throws NullPointerException {
//        if (Context == null) throw new NullPointerException("context have not set");
//        long timer = System.currentTimeMillis();
//        if (timer - timer_short > 3000) {
//            android.widget.Toast.makeText(context, s, android.widget.Toast.LENGTH_SHORT).show();
//            timer_short = timer;
//        }
//    }
//}

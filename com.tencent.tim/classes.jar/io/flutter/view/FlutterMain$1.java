package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class FlutterMain$1
  implements Runnable
{
  FlutterMain$1(Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable) {}
  
  public void run()
  {
    if (FlutterMain.access$000() != null) {
      FlutterMain.access$000().waitForCompletion();
    }
    new Handler(Looper.getMainLooper()).post(new FlutterMain.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.FlutterMain.1
 * JD-Core Version:    0.7.0.1
 */
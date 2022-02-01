package com.tencent.biz.game;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jqo;
import lg;

class SensorAPIJavaScript$11
  extends Thread
{
  SensorAPIJavaScript$11(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString) {}
  
  public void run()
  {
    int i = 15;
    String str = "";
    if ((i > 0) && (this.this$0.mWebView != null)) {
      if (this.this$0.mWebView.get() == null) {
        i = 2;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.this$0.abn = false;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check end: " + i);
        }
        if (i != 0) {
          break label200;
        }
        int j = this.this$0.mU();
        this.this$0.callJs(this.val$callback, new String[] { jqo.toJsString(Integer.toString(i)), jqo.toJsString(str), jqo.toJsString(Integer.toString(j)) });
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check: " + i);
        }
        str = lg.s(this.val$context);
        if (!TextUtils.isEmpty(str)) {
          i = 0;
        } else {
          try
          {
            Thread.sleep(2000L);
            i -= 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 2;
          }
        }
      }
      continue;
      label200:
      this.this$0.callJs(this.val$callback, new String[] { jqo.toJsString(Integer.toString(i)) });
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.11
 * JD-Core Version:    0.7.0.1
 */
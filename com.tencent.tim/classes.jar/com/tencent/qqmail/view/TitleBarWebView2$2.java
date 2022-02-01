package com.tencent.qqmail.view;

import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;

class TitleBarWebView2$2
  implements Runnable
{
  TitleBarWebView2$2(TitleBarWebView2 paramTitleBarWebView2) {}
  
  public void run()
  {
    if (TitleBarWebView2.access$100(this.this$0) != this.this$0.getScale())
    {
      TitleBarWebView2.access$200(this.this$0);
      Log.v("yugo", "resetContentHeight2");
      QMLog.log(4, TitleBarWebView2.TAG, "resetContentHeight2 again");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.TitleBarWebView2.2
 * JD-Core Version:    0.7.0.1
 */
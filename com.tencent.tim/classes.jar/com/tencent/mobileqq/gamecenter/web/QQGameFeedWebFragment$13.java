package com.tencent.mobileqq.gamecenter.web;

import ahty;
import android.os.SystemClock;
import aurr;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$13
  implements Runnable
{
  QQGameFeedWebFragment$13(QQGameFeedWebFragment paramQQGameFeedWebFragment, int paramInt) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.this$0) != null)
    {
      String str = ahty.wG();
      if (aurr.isValidUrl(str))
      {
        str = QQGameFeedWebFragment.a(this.this$0, str, QQGameFeedWebFragment.a(this.this$0), this.dbu);
        if (QLog.isColorLevel()) {
          QLog.d("GameWebPage", 1, "paramUrl = " + str);
        }
        this.this$0.aaY = SystemClock.elapsedRealtime();
        QQGameFeedWebFragment.a(this.this$0).loadUrl(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.13
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.tim.timme;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;

class TimLeba$5
  implements Runnable
{
  TimLeba$5(TimLeba paramTimLeba, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.app.a(this.val$uin, (byte)1, true);
    this.this$0.runOnUiThread(new TimLeba.5.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.tim.timme.TimLeba.5
 * JD-Core Version:    0.7.0.1
 */
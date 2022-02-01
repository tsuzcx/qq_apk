package com.tencent.qqmail.calendar.fragment;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.ui.QMTips;

class CalendarShareFragment$2$1$2
  implements ImageDownloadListener
{
  CalendarShareFragment$2$1$2(CalendarShareFragment.2.1 param1) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    this.this$2.this$1.this$0.getTips().hide();
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.this$2.this$1.this$0.getTips().hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment.2.1.2
 * JD-Core Version:    0.7.0.1
 */
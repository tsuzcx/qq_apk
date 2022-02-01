package com.tencent.qqmail.sendmaillist;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.ui.QMTips;

class SendMailListFragment$1$1$2
  implements ImageDownloadListener
{
  SendMailListFragment$1$1$2(SendMailListFragment.1.1 param1) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.1.1.2
 * JD-Core Version:    0.7.0.1
 */
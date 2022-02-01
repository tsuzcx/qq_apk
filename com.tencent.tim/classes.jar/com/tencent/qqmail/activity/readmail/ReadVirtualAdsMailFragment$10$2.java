package com.tencent.qqmail.activity.readmail;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;

class ReadVirtualAdsMailFragment$10$2
  implements ImageDownloadListener
{
  ReadVirtualAdsMailFragment$10$2(ReadVirtualAdsMailFragment.10 param10, String paramString) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(4, ReadVirtualAdsMailFragment.TAG, String.format("url = %s, path = %s", new Object[] { paramString1, paramString2 }));
    ReadVirtualAdsMailFragment.access$2200(this.this$1.this$0).put(this.val$imageUrl, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.10.2
 * JD-Core Version:    0.7.0.1
 */
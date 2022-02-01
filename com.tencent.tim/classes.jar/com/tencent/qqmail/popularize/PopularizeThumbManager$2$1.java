package com.tencent.qqmail.popularize;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class PopularizeThumbManager$2$1
  implements ImageDownloadListener
{
  PopularizeThumbManager$2$1(PopularizeThumbManager.2 param2) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    String str = paramObject + "";
    if (!str.equals("fromDisk")) {
      QMLog.log(6, "PopularizeThumbManager", "loadPopularizeThumb error url = " + paramString + " error = " + str.toString());
    }
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onErrorInMainThread(paramString, paramObject);
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2)
  {
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onProgressInMainThread(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("loadPopularizeThumb success url = ").append(paramString1).append(" bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(4, "PopularizeThumbManager", bool + " storePath = " + paramString2);
      if (this.this$1.val$listener != null) {
        this.this$1.val$listener.onSuccessInMainThread(paramString1, paramBitmap, paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeThumbManager.2.1
 * JD-Core Version:    0.7.0.1
 */
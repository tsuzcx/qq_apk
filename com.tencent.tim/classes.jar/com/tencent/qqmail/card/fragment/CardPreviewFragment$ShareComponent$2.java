package com.tencent.qqmail.card.fragment;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class CardPreviewFragment$ShareComponent$2
  implements ImageDownloadListener
{
  CardPreviewFragment$ShareComponent$2(CardPreviewFragment.ShareComponent paramShareComponent) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "CardPreviewFragment", "cardPreview load thumb fail:" + paramObject);
    CardPreviewFragment.access$3100(this.this$1.this$0, null);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(3, "CardPreviewFragment", "cardPreview load thumb");
    CardPreviewFragment.ShareComponent.access$3302(this.this$1, paramBitmap);
    CardPreviewFragment.ShareComponent.access$2900(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.ShareComponent.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.card.view.card;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseCard$1
  implements ImageDownloadListener
{
  BaseCard$1(BaseCard paramBaseCard) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if (BaseCard.access$000(this.this$0).equals(paramString)) {
      this.this$0.mCardCoverView.setImageDrawable(this.this$0.mDefaultCover);
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(2, "BaseCard", "load Cover Image: url: " + paramString1 + ", req: " + BaseCard.access$000(this.this$0));
    if (BaseCard.access$000(this.this$0).equals(paramString1))
    {
      this.this$0.mCardCoverView.setImageBitmap(paramBitmap);
      this.this$0.mCardCoverView.postInvalidate();
      this.this$0.onBitmapChanged(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.card.BaseCard.1
 * JD-Core Version:    0.7.0.1
 */
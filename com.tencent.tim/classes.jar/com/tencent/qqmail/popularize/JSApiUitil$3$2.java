package com.tencent.qqmail.popularize;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.popularize.model.PopularizeMoreOperation;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

class JSApiUitil$3$2
  implements ImageDownloadListener
{
  JSApiUitil$3$2(JSApiUitil.3 param3, PopularizeMoreOperation paramPopularizeMoreOperation) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMUIHelper.showToast(JSApiUitil.3.access$400(this.this$0), 2131697038, "");
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramBitmap = this.val$operation.getUrl();
    if (paramBitmap != null)
    {
      paramString1 = paramBitmap;
      if (!paramBitmap.equals("")) {}
    }
    else
    {
      paramString1 = this.this$0.val$orginalUrl;
    }
    JSApiUitil.access$000(JSApiUitil.3.access$300(this.this$0), 0, paramString1, this.val$operation.getTitle(), this.val$operation.getAbstracts(), this.val$operation.getImageUrl(), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.3.2
 * JD-Core Version:    0.7.0.1
 */
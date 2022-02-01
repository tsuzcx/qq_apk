package com.tencent.qqmail.popularize;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

final class JSApiUitil$2
  implements ImageDownloadListener
{
  JSApiUitil$2(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, JSApiUitil.JSAsyncCallback paramJSAsyncCallback, String paramString5, String paramString6, String paramString7) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "JSApiUitil", "shareToWx loadPopularizeThumbWithCallBack error" + paramString);
    this.val$callback.onError(JSApiUitil.handleJsCallBack(false, this.val$errorTips, this.val$callBackId));
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(4, "JSApiUitil", "shareToWx loadPopularizeThumbWithCallBack" + paramString1);
    if (JSApiUitil.access$000(this.val$context, this.val$type, this.val$openUrl, this.val$title, this.val$abstracts, this.val$imageUrl, this.val$en))
    {
      this.val$callback.onSuccess(JSApiUitil.handleJsCallBack(true, this.val$successTips, this.val$callBackId));
      return;
    }
    this.val$callback.onError(JSApiUitil.handleJsCallBack(false, this.val$errorTips, this.val$callBackId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.2
 * JD-Core Version:    0.7.0.1
 */
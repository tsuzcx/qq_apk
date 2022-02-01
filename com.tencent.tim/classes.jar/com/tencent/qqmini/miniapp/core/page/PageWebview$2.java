package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PageWebview$2
  implements Runnable
{
  PageWebview$2(PageWebview paramPageWebview, PageWebview.WebviewShotCallback paramWebviewShotCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.getContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = (int)(((DisplayMetrics)localObject).widthPixels * 0.8D);
      localObject = PageWebview.screenShot(this.this$0, i, j);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        if (this.val$callback != null) {
          this.val$callback.onShotReady((Bitmap)localObject);
        }
      }
      else if (this.val$callback != null)
      {
        this.val$callback.onShotReady(null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PageWebview", "shotWebview error.");
      if (this.val$callback != null) {
        this.val$callback.onShotReady(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebview.2
 * JD-Core Version:    0.7.0.1
 */
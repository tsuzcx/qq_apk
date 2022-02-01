package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.page.BrandPagePool;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.qphone.base.util.QLog;

public class PagePreloadTask
  extends AsyncTask
{
  public PagePreloadTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeAsync()
  {
    try
    {
      BrandPagePool.g().preloadLoadingUI();
      BrandPagePool.g().preloadBrandPage(this.mContext);
      onTaskSucceed();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("miniapp-start", 1, "exception:", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.PagePreloadTask
 * JD-Core Version:    0.7.0.1
 */
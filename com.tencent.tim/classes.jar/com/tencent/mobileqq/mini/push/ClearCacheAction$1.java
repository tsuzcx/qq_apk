package com.tencent.mobileqq.mini.push;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import mqq.app.AppRuntime;

class ClearCacheAction$1
  implements ThreadExcutor.IThreadListener
{
  ClearCacheAction$1(ClearCacheAction paramClearCacheAction, String paramString) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    AppLoaderFactory.g().getMiniCacheFreeManager().freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.val$appId, true);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.ClearCacheAction.1
 * JD-Core Version:    0.7.0.1
 */
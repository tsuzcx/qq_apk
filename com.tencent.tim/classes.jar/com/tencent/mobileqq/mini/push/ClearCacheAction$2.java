package com.tencent.mobileqq.mini.push;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import mqq.os.MqqHandler;

class ClearCacheAction$2
  implements ThreadExcutor.IThreadListener
{
  ClearCacheAction$2(ClearCacheAction paramClearCacheAction) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    AppLoaderFactory.g().getMiniCacheFreeManager().freeCache();
    ThreadManager.getSubThreadHandler().postDelayed(new ClearCacheAction.2.1(this), 3000L);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.ClearCacheAction.2
 * JD-Core Version:    0.7.0.1
 */
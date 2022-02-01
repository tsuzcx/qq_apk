package com.tencent.mobileqq.activity.qwallet.preload;

import java.lang.ref.WeakReference;

class PreloadResource$1
  extends PreloadResource.PreloadTimerTask
{
  PreloadResource$1(PreloadResource paramPreloadResource, WeakReference paramWeakReference, PreloadModule paramPreloadModule) {}
  
  public void exec()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.eO.get();
    if ((PreloadManager.a(localPreloadManager)) && (localPreloadManager.isResInConfig(this.this$0))) {
      localPreloadManager.a(this.this$0, this.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource.1
 * JD-Core Version:    0.7.0.1
 */
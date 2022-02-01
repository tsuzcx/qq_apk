package com.tencent.mobileqq.activity.qwallet.preload;

import java.lang.ref.WeakReference;

class PreloadManager$5
  implements Runnable
{
  PreloadManager$5(PreloadManager paramPreloadManager, WeakReference paramWeakReference, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.eN != null)
    {
      PreloadManager localPreloadManager = (PreloadManager)this.eN.get();
      if ((localPreloadManager != null) && (!localPreloadManager.Vn)) {
        localPreloadManager.Cc(this.buZ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.5
 * JD-Core Version:    0.7.0.1
 */
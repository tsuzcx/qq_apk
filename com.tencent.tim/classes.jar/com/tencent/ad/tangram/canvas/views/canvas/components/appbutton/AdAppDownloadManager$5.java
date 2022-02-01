package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.content.Context;
import java.lang.ref.WeakReference;

class AdAppDownloadManager$5
  implements Runnable
{
  AdAppDownloadManager$5(AdAppDownloadManager paramAdAppDownloadManager, AdAppDownloadManager.d paramd) {}
  
  public void run()
  {
    if ((AdAppDownloadManager.access$700(this.this$0) == null) || (AdAppDownloadManager.access$700(this.this$0).get() == null) || (AdAppDownloadManager.access$200(this.this$0) == null)) {
      return;
    }
    if (this.this$0.isPkgExist((Context)AdAppDownloadManager.access$700(this.this$0).get(), AdAppDownloadManager.access$200(this.this$0).packageName, AdAppDownloadManager.access$200(this.this$0).apkUrlhttp))
    {
      this.val$callback.onPkgExist(true);
      return;
    }
    this.val$callback.onPkgExist(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */
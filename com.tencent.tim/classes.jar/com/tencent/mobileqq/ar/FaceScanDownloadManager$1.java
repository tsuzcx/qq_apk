package com.tencent.mobileqq.ar;

import adfa.a;

public final class FaceScanDownloadManager$1
  implements Runnable
{
  public FaceScanDownloadManager$1(adfa.a parama, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.a != null) {
      this.a.onProgress(this.val$type, this.val$progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */
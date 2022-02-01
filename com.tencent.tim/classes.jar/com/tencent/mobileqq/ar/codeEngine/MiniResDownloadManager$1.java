package com.tencent.mobileqq.ar.codeEngine;

import adjr.a;

public final class MiniResDownloadManager$1
  implements Runnable
{
  public MiniResDownloadManager$1(adjr.a parama, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.a != null) {
      this.a.onProgress(this.val$type, this.val$progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */
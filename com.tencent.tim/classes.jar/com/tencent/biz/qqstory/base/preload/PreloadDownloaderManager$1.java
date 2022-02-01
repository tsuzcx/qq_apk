package com.tencent.biz.qqstory.base.preload;

import pnm;
import pnr;

public class PreloadDownloaderManager$1
  implements Runnable
{
  public PreloadDownloaderManager$1(pnm parampnm) {}
  
  public void run()
  {
    this.this$0.a.onStop();
    this.this$0.mStopRunnable = null;
    pnr.a().blX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.1
 * JD-Core Version:    0.7.0.1
 */
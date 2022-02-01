package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class TinyImageSeqLoader$1
  implements AttachDownloadListener
{
  TinyImageSeqLoader$1(TinyImageSeqLoader paramTinyImageSeqLoader, long paramLong, int paramInt) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    Threads.runOnMainThread(new TinyImageSeqLoader.1.2(this, paramString));
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    Threads.runOnMainThread(new TinyImageSeqLoader.1.1(this, paramString2, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader.1
 * JD-Core Version:    0.7.0.1
 */
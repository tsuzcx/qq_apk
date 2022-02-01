package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.delegate.RenameDelegate;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.exception.ThreadTaskError;
import com.tencent.moai.downloader.file.DownloadFileUtil;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.listener.ThreadTaskListener;
import com.tencent.moai.downloader.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class DownloadTask$4
  implements ThreadTaskListener
{
  DownloadTask$4(DownloadTask paramDownloadTask) {}
  
  public void onAbort(long paramLong1, long paramLong2, String paramString) {}
  
  public void onFail(long paramLong1, long paramLong2, String paramString, ThreadTaskError paramThreadTaskError)
  {
    synchronized (DownloadTask.access$600(this.this$0))
    {
      boolean bool = DownloadTask.access$800(this.this$0);
      if (bool)
      {
        DownloadTask.access$300(this.this$0).setStatus(5);
        DownloadTask.access$500(this.this$0).onFail(paramLong2, paramString, new DownloadTaskError(paramThreadTaskError.getErrorCode(), paramThreadTaskError.getMessage()));
      }
      Logger.e("DownloadTask", "onFail id:" + paramLong1 + " taskId:" + paramLong2 + " url:" + paramString + " isAllSuccessOrFail:" + bool);
      return;
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4)
  {
    synchronized (DownloadTask.access$600(this.this$0))
    {
      Iterator localIterator = DownloadTask.access$600(this.this$0).iterator();
      for (paramLong1 = 0L; localIterator.hasNext(); paramLong1 = ((ThreadTask)localIterator.next()).getDownloadSize() + paramLong1) {}
      this.this$0.setDownloadSize(paramLong1);
      DownloadTask.access$300(this.this$0).setStatus(2);
      DownloadTask.access$500(this.this$0).onProgress(paramLong2, paramString, this.this$0.getDownloadSize(), this.this$0.getFileSize());
      return;
    }
  }
  
  public void onReceiveHeader(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.this$0.isSingleTaskDownload())
    {
      this.this$0.setFileSize(paramLong2);
      this.this$0.setAcceptRange(paramBoolean);
    }
  }
  
  public void onStart(long paramLong1, long paramLong2, String paramString) {}
  
  public void onSuccess(long paramLong1, long paramLong2, String paramString1, String arg6)
  {
    for (;;)
    {
      boolean bool2;
      synchronized (DownloadTask.access$600(this.this$0))
      {
        boolean bool1 = DownloadTask.access$700(this.this$0);
        bool2 = DownloadTask.access$800(this.this$0);
        if (bool1)
        {
          DownloadTask.access$300(this.this$0).setStatus(3);
          if (new File(DownloadTask.access$900(this.this$0)).exists())
          {
            DownloadTask.access$902(this.this$0, DownloadTask.access$1000(this.this$0).rename(DownloadTask.access$900(this.this$0)));
            Logger.i("DownloadTask", "destFile exist rename to:" + DownloadTask.access$900(this.this$0));
          }
          if (DownloadFileUtil.combineTmpFile(DownloadTask.access$1100(this.this$0), DownloadTask.access$900(this.this$0)))
          {
            DownloadTask.access$300(this.this$0).setStatus(4);
            Logger.i("DownloadTask", "combine success:" + DownloadTask.access$900(this.this$0));
            if (DownloadTask.access$500(this.this$0) != null) {
              DownloadTask.access$500(this.this$0).onSuccess(paramLong2, paramString1, DownloadTask.access$900(this.this$0));
            }
            Logger.i("DownloadTask", "onSuccess id:" + paramLong1 + " taskId:" + paramLong2 + " url:" + paramString1 + " isAllSuccessOrFail:" + bool1 + " isAllSuccessOrFail:" + bool2);
            return;
          }
          DownloadTask.access$500(this.this$0).onFail(paramLong2, paramString1, new DownloadTaskError(1, "combine tmp file error"));
          Logger.e("DownloadTask", "combine error:" + DownloadTask.access$900(this.this$0));
        }
      }
      if (bool2)
      {
        DownloadTask.access$300(this.this$0).setStatus(5);
        DownloadTask.access$500(this.this$0).onFail(paramLong2, paramString1, new DownloadTaskError(2, "download error"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.DownloadTask.4
 * JD-Core Version:    0.7.0.1
 */
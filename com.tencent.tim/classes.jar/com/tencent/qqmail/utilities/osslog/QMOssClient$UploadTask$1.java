package com.tencent.qqmail.utilities.osslog;

import android.os.SystemClock;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.ReportFileHandler;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;
import rx.functions.Func1;

class QMOssClient$UploadTask$1
  implements Func1<Integer, Void>
{
  QMOssClient$UploadTask$1(QMOssClient.UploadTask paramUploadTask, List paramList, long paramLong1, long paramLong2, long paramLong3) {}
  
  public Void call(Integer paramInteger)
  {
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      QMOssClient.access$000(this.this$1.this$0).finishUpload();
      long l = SystemClock.elapsedRealtime();
      QMLog.log(4, "QMOssClient", "finish upload request, ret: " + paramInteger + ", instant: " + this.this$1.instant + ", prepare: " + this.val$prepareCost + "ms, request: " + (l - this.val$requestStart) + "ms, total: " + (l - this.val$totalStart) + "ms");
      if (QMOssClient.access$100(this.this$1.this$0) != null)
      {
        Threads.replaceCallbackInBackground(QMOssClient.access$100(this.this$1.this$0), 1000L);
        QMOssClient.access$102(this.this$1.this$0, null);
      }
      return null;
      ReportFileHandler.deleteFiles(this.val$fileList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.QMOssClient.UploadTask.1
 * JD-Core Version:    0.7.0.1
 */
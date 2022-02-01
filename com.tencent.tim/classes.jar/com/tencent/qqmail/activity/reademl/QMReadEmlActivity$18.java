package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.download.loader.TinyImageSeqLoader.Listener;
import com.tencent.qqmail.utilities.thread.Threads;

class QMReadEmlActivity$18
  implements TinyImageSeqLoader.Listener
{
  QMReadEmlActivity$18(QMReadEmlActivity paramQMReadEmlActivity, int paramInt) {}
  
  public void onBefore()
  {
    QMReadEmlActivity.SeqDownloadInfo localSeqDownloadInfo = new QMReadEmlActivity.SeqDownloadInfo(null);
    localSeqDownloadInfo.totalCount = this.val$totalCount;
    localSeqDownloadInfo.currentCount = 0;
    Threads.runOnMainThread(new QMReadEmlActivity.18.3(this, localSeqDownloadInfo));
  }
  
  public void onChangeNext(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramString1 = new QMReadEmlActivity.SeqDownloadInfo(null);
    paramString1.totalCount = this.val$totalCount;
    paramString1.currentCount = paramInt1;
    paramString1.successCount = paramInt2;
    paramString1.failCount = paramInt3;
    paramString1.isComplete = false;
    paramString1.isDownSuccess = paramBoolean;
    Threads.runOnMainThread(new QMReadEmlActivity.18.2(this, paramString1));
  }
  
  public void onComplete(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QMReadEmlActivity.SeqDownloadInfo localSeqDownloadInfo = new QMReadEmlActivity.SeqDownloadInfo(null);
    localSeqDownloadInfo.totalCount = this.val$totalCount;
    localSeqDownloadInfo.currentCount = (paramInt1 + paramInt2);
    localSeqDownloadInfo.successCount = paramInt1;
    localSeqDownloadInfo.failCount = paramInt2;
    localSeqDownloadInfo.filePath = paramString;
    localSeqDownloadInfo.errCode = paramInt4;
    localSeqDownloadInfo.isComplete = true;
    Threads.runOnMainThread(new QMReadEmlActivity.18.1(this, localSeqDownloadInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.18
 * JD-Core Version:    0.7.0.1
 */
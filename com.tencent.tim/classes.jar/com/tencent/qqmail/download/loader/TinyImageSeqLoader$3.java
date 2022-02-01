package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class TinyImageSeqLoader$3
  implements QMCallback.IErrorCallback
{
  TinyImageSeqLoader$3(TinyImageSeqLoader paramTinyImageSeqLoader, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    Threads.runOnMainThread(new TinyImageSeqLoader.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader.3
 * JD-Core Version:    0.7.0.1
 */
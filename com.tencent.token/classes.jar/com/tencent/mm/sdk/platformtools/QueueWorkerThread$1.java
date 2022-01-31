package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Message;

class QueueWorkerThread$1
  extends Handler
{
  QueueWorkerThread$1(QueueWorkerThread paramQueueWorkerThread) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((QueueWorkerThread.ThreadObject)paramMessage.obj).onPostExecute();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread.1
 * JD-Core Version:    0.7.0.1
 */
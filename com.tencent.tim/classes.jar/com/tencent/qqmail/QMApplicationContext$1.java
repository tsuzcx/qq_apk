package com.tencent.qqmail;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.thread.Threads;

class QMApplicationContext$1
  extends SimpleOnProtocolListener
{
  QMApplicationContext$1(QMApplicationContext paramQMApplicationContext) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    Threads.runInBackground(new QMApplicationContext.1.1(this, paramCloudProtocolResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.1
 * JD-Core Version:    0.7.0.1
 */
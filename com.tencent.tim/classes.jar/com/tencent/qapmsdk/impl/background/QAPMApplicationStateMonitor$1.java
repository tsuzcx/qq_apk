package com.tencent.qapmsdk.impl.background;

import java.util.concurrent.ThreadFactory;

class QAPMApplicationStateMonitor$1
  implements ThreadFactory
{
  QAPMApplicationStateMonitor$1(QAPMApplicationStateMonitor paramQAPMApplicationStateMonitor) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "[QAPMAgent] App State Monitor");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.background.QAPMApplicationStateMonitor.1
 * JD-Core Version:    0.7.0.1
 */
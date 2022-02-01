package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;

class BaseActivityImpl$6$2
  implements Runnable
{
  BaseActivityImpl$6$2(BaseActivityImpl.6 param6, String paramString) {}
  
  public void run()
  {
    QMWatcherCenter.triggerSecAppWatcher(this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.6.2
 * JD-Core Version:    0.7.0.1
 */
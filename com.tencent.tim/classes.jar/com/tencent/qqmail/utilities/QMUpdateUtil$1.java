package com.tencent.qqmail.utilities;

import com.tencent.qqmail.activity.watcher.AppStatusWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class QMUpdateUtil$1
  implements AppStatusWatcher
{
  QMUpdateUtil$1(QMUpdateUtil paramQMUpdateUtil) {}
  
  public void gotoBackGround() {}
  
  public void gotoForGround()
  {
    QMLog.log(4, QMUpdateUtil.access$000(), "AppStatusWatcher. app go foreground");
    Threads.runOnMainThread(new QMUpdateUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUpdateUtil.1
 * JD-Core Version:    0.7.0.1
 */
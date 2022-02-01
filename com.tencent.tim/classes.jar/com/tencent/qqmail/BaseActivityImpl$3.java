package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.watcher.SendMailSuccWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$3
  implements SendMailSuccWatcher
{
  BaseActivityImpl$3(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onSuccess(ComposeMailUI paramComposeMailUI)
  {
    Threads.runOnMainThread(new BaseActivityImpl.3.1(this, paramComposeMailUI));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.3
 * JD-Core Version:    0.7.0.1
 */
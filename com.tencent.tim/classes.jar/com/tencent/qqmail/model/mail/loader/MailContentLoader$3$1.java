package com.tencent.qqmail.model.mail.loader;

import com.tencent.qqmail.model.mail.watcher.CompressImageWatcher;
import com.tencent.qqmail.utilities.thread.Threads;

class MailContentLoader$3$1
  implements CompressImageWatcher
{
  MailContentLoader$3$1(MailContentLoader.3 param3) {}
  
  public void onError(String paramString1, String paramString2) {}
  
  public void onSuccess(String paramString1, String paramString2)
  {
    Threads.runOnMainThread(new MailContentLoader.3.1.1(this, paramString2));
  }
  
  public void onWait(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.3.1
 * JD-Core Version:    0.7.0.1
 */
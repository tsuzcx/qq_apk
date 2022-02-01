package com.tencent.qqmail;

import com.tencent.qqmail.calendar.watcher.CalendarFollowWatcher;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$18
  implements CalendarFollowWatcher
{
  BaseActivityImpl$18(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onError(String paramString1, String paramString2, String paramString3)
  {
    if (BaseActivityImpl.access$000(this.this$0) == null) {
      return;
    }
    Threads.runOnMainThread(new BaseActivityImpl.18.3(this, paramString3));
  }
  
  public void onProcess(String paramString1, String paramString2)
  {
    if (BaseActivityImpl.access$000(this.this$0) == null) {
      return;
    }
    Threads.runOnMainThread(new BaseActivityImpl.18.1(this));
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    if (BaseActivityImpl.access$000(this.this$0) == null) {
      return;
    }
    Threads.runOnMainThread(new BaseActivityImpl.18.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.18
 * JD-Core Version:    0.7.0.1
 */
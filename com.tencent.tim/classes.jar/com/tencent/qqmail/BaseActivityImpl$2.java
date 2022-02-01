package com.tencent.qqmail;

import com.tencent.qqmail.activity.watcher.SaveToMyFtnWatcher;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$2
  implements SaveToMyFtnWatcher
{
  BaseActivityImpl$2(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onBegin()
  {
    Threads.runOnMainThread(new BaseActivityImpl.2.3(this));
  }
  
  public void onError(int paramInt)
  {
    Threads.runOnMainThread(new BaseActivityImpl.2.2(this, paramInt));
  }
  
  public void onSuccess()
  {
    Threads.runOnMainThread(new BaseActivityImpl.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.2
 * JD-Core Version:    0.7.0.1
 */
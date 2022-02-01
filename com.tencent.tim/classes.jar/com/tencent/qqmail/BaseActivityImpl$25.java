package com.tencent.qqmail;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$25
  implements ICallBack
{
  BaseActivityImpl$25(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new BaseActivityImpl.25.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.25
 * JD-Core Version:    0.7.0.1
 */
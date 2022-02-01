package com.tencent.qqmail;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$24
  implements ICallBack
{
  BaseActivityImpl$24(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new BaseActivityImpl.24.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.24
 * JD-Core Version:    0.7.0.1
 */
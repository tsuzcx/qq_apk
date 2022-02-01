package com.tencent.aekit.target.utils;

class HandlerWrapper$1
  implements Runnable
{
  HandlerWrapper$1(HandlerWrapper paramHandlerWrapper, Object paramObject, Runnable paramRunnable) {}
  
  public void run()
  {
    synchronized (this.val$syncObj)
    {
      this.val$r.run();
      this.val$syncObj.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.target.utils.HandlerWrapper.1
 * JD-Core Version:    0.7.0.1
 */
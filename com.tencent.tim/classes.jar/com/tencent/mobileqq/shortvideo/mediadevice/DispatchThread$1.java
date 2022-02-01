package com.tencent.mobileqq.shortvideo.mediadevice;

class DispatchThread$1
  implements Runnable
{
  DispatchThread$1(DispatchThread paramDispatchThread) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      this.this$0.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.shortvideo.mediadevice;

import anim.i;

public class CameraProxy$WaitDoneBundle$1
  implements Runnable
{
  public CameraProxy$WaitDoneBundle$1(anim.i parami) {}
  
  public void run()
  {
    synchronized (this.this$0.bi)
    {
      this.this$0.bi.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1
 * JD-Core Version:    0.7.0.1
 */
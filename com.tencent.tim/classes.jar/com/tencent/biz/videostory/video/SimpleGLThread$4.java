package com.tencent.biz.videostory.video;

public class SimpleGLThread$4
  implements Runnable
{
  public void run()
  {
    synchronized (this.bC)
    {
      this.bC.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.4
 * JD-Core Version:    0.7.0.1
 */
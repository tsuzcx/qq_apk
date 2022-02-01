package com.tencent.biz.videostory.video;

import sqw;

public class SimpleGLThread$2
  implements Runnable
{
  public SimpleGLThread$2(sqw paramsqw, Object paramObject) {}
  
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
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.camera;

public class CameraManagerImpl$CameraHandler$2
  implements Runnable
{
  public void run()
  {
    synchronized (this.dl)
    {
      this.dl.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.CameraManagerImpl.CameraHandler.2
 * JD-Core Version:    0.7.0.1
 */
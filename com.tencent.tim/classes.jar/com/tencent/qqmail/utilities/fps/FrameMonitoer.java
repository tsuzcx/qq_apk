package com.tencent.qqmail.utilities.fps;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

public class FrameMonitoer
  implements Monitor
{
  private static volatile FrameMonitoer instance;
  private Choreographer.FrameCallback qmFrameCallback;
  
  public static FrameMonitoer getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new FrameMonitoer();
      }
      return instance;
    }
    finally {}
  }
  
  public void startMonitor()
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      this.qmFrameCallback = new PerSecCallback();
      Choreographer.getInstance().postFrameCallback(this.qmFrameCallback);
    }
  }
  
  public void stopMonitor()
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      Choreographer.getInstance().removeFrameCallback(this.qmFrameCallback);
      this.qmFrameCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fps.FrameMonitoer
 * JD-Core Version:    0.7.0.1
 */
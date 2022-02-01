package com.tencent.qqmail.utilities.screenshot;

import android.os.RemoteException;

public abstract interface ScreenshotWatcher
{
  public abstract boolean isWatching();
  
  public abstract void release();
  
  public abstract void startWatching();
  
  public abstract void stopWatching();
  
  public static abstract interface ScreenshotCallback
  {
    public abstract void onScreenshot()
      throws RemoteException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenshotWatcher
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.utilities.screenshot;

import android.os.RemoteException;

class ScreenshotFileWatcher$MFileObserver$1
  implements Runnable
{
  ScreenshotFileWatcher$MFileObserver$1(ScreenshotFileWatcher.MFileObserver paramMFileObserver) {}
  
  public void run()
  {
    try
    {
      ScreenshotFileWatcher.MFileObserver.access$000(this.this$0).onScreenshot();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenshotFileWatcher.MFileObserver.1
 * JD-Core Version:    0.7.0.1
 */
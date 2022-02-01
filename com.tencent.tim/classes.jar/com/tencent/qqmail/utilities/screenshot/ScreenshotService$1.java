package com.tencent.qqmail.utilities.screenshot;

import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class ScreenshotService$1
  implements ScreenshotWatcher.ScreenshotCallback
{
  ScreenshotService$1(ScreenshotService paramScreenshotService) {}
  
  public void onScreenshot()
  {
    Log.i(ScreenshotService.TAG, "Screenshot happens");
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    try
    {
      ScreenshotService.access$000(this.this$0).send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i(ScreenshotService.TAG, "result call back error!!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenshotService.1
 * JD-Core Version:    0.7.0.1
 */
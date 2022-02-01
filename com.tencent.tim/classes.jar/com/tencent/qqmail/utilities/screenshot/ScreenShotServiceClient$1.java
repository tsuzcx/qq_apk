package com.tencent.qqmail.utilities.screenshot;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;

class ScreenShotServiceClient$1
  implements ServiceConnection
{
  ScreenShotServiceClient$1(ScreenShotServiceClient paramScreenShotServiceClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Log.i(ScreenShotServiceClient.TAG, "ScreenshotService connected");
    ScreenShotServiceClient.access$002(this.this$0, new Messenger(paramIBinder));
    this.this$0.registToService();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QMLog.log(4, ScreenShotServiceClient.TAG, "ScreenshotService disconnected");
    Log.i(ScreenShotServiceClient.TAG, "ScreenshotService disconnected");
    ScreenShotServiceClient.access$002(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenShotServiceClient.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmail.utilities.screenshot;

import android.os.RemoteException;

class ScreenShotServiceClient$ClientHandler$1
  implements Runnable
{
  ScreenShotServiceClient$ClientHandler$1(ScreenShotServiceClient.ClientHandler paramClientHandler, ScreenShotServiceClient paramScreenShotServiceClient) {}
  
  public void run()
  {
    try
    {
      ScreenShotServiceClient.access$100(this.val$client).onScreenshot();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenShotServiceClient.ClientHandler.1
 * JD-Core Version:    0.7.0.1
 */
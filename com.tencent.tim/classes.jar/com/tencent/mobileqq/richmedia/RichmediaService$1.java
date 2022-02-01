package com.tencent.mobileqq.richmedia;

import alvq;
import alvr;
import android.os.Bundle;
import android.os.RemoteException;

final class RichmediaService$1
  implements Runnable
{
  RichmediaService$1(int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (RichmediaService.a != null)
    {
      alvq localalvq = RichmediaService.a.b;
      if (localalvq != null) {
        try
        {
          alvr.d("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localalvq.K(this.qA, this.val$data);
          alvr.d("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          alvr.d("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      alvr.d("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    alvr.d("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.1
 * JD-Core Version:    0.7.0.1
 */
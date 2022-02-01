package cooperation.qqreader.host.binder;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;

class HostBinderInterface$1
  extends RemoteResultCallback
{
  HostBinderInterface$1(HostBinderInterface paramHostBinderInterface, HostBinderInterface.TransferCallback paramTransferCallback) {}
  
  public void onCallback(Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.onCallback(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterface.1
 * JD-Core Version:    0.7.0.1
 */
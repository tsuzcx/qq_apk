import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.util.BinderWarpper;

class alvt
  implements ServiceConnection
{
  alvt(alvs paramalvs) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    alvr.d("PTV.RichmediaClient", "onServiceConnected");
    this.b.mService = new Messenger(paramIBinder);
    paramComponentName = Message.obtain(null, 1);
    paramComponentName.replyTo = this.b.mMessenger;
    paramIBinder = new BinderWarpper(this.b.a.asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ICallBack_BinderWrapper", paramIBinder);
    paramComponentName.setData(localBundle);
    try
    {
      this.b.mService.send(paramComponentName);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      alvr.e("PTV.RichmediaClient", "MSG_C2S_REGISTER_CLIENT send failed. e = " + paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.b.mService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvt
 * JD-Core Version:    0.7.0.1
 */
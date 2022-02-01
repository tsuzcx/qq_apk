import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class awjh
  implements ServiceConnection
{
  awjh(awjf paramawjf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    awjf.a(this.this$0).removeMessages(1);
    this.this$0.dnf = false;
    this.this$0.a = awje.a.a(paramIBinder);
    this.this$0.eAu();
    QLog.d("SmartDeviceIPCHost", 1, "plugin service connected");
    if (this.this$0.app != null) {
      tar.a(this.this$0.app, "Net_Start_Service_Host", 0, 1, 0);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (this.this$0.app != null) {
        this.this$0.app.getApplication().unbindService(this.this$0.mServiceConnection);
      }
      label30:
      this.this$0.a = null;
      this.this$0.dnf = false;
      QLog.d("SmartDeviceIPCHost", 1, "plugin service disconnected");
      return;
    }
    catch (Exception paramComponentName)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjh
 * JD-Core Version:    0.7.0.1
 */
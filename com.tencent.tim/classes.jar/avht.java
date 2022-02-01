import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class avht
  implements ServiceConnection
{
  avht(avhs paramavhs) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    avhs.a(this.this$0, avhb.a.a(paramIBinder));
    avhs.a(this.this$0, false);
    avhs.a(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + paramComponentName);
    try
    {
      avhs.a(this.this$0).getApplication().unbindService(avhs.a(this.this$0));
      avhs.a(this.this$0, null);
      avhs.a(this.this$0, false);
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avht
 * JD-Core Version:    0.7.0.1
 */
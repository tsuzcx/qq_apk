import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class adbt
  implements ServiceConnection
{
  adbt(adbr paramadbr) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.w(adca.TAG, 1, "onServiceConnected, name[" + paramComponentName + "]");
    try
    {
      this.a.a = adgj.a.a(paramIBinder);
      this.a.a.a(adbr.a(this.a));
      this.a.a.cQW();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(adca.TAG, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.w(adca.TAG, 1, "onServiceDisconnected, name[" + paramComponentName + "]");
    this.a.clean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbt
 * JD-Core Version:    0.7.0.1
 */
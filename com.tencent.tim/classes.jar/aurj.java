import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo.1;

public class aurj
  implements ServiceConnection
{
  public aurj(QQDeviceInfo.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = auyf.a.a(paramIBinder);
      try
      {
        auri.access$002(paramComponentName.getOaid());
        auri.access$100("huawei_oaid", auri.access$000());
        if (QLog.isColorLevel()) {
          QLog.d(auri.TAG, 2, "huawei oaid = " + auri.access$000());
        }
        return;
      }
      catch (SecurityException paramComponentName)
      {
        paramComponentName.printStackTrace();
        QLog.e(auri.TAG, 2, paramComponentName, new Object[0]);
        return;
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
      QLog.e(auri.TAG, 2, "get huawei oaid throw e", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aurj
 * JD-Core Version:    0.7.0.1
 */
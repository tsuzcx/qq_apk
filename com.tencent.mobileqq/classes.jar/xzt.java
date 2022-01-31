import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class xzt
  implements ServiceConnection
{
  xzt(xzr paramxzr) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    xzr.a(this.a, ((yga)paramIBinder).a());
    if ((!xzr.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!xzr.a(this.a).isEmpty())
    {
      this.a.a = ((ygf)xzr.a(this.a).get(0));
      xzr.a(this.a).remove(0);
      xzr.a(this.a).a(this.a.a.a, this.a.a.b);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    xzr.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xzt
 * JD-Core Version:    0.7.0.1
 */
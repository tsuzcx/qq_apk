import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class xqt
  implements ServiceConnection
{
  xqt(xqr paramxqr) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    xqr.a(this.a, ((xwz)paramIBinder).a());
    if ((!xqr.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!xqr.a(this.a).isEmpty())
    {
      this.a.a = ((xxe)xqr.a(this.a).get(0));
      xqr.a(this.a).remove(0);
      xqr.a(this.a).a(this.a.a.a, this.a.a.b);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    xqr.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xqt
 * JD-Core Version:    0.7.0.1
 */
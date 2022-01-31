import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class zom
  implements ServiceConnection
{
  zom(zok paramzok) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zok.a(this.a, ((zut)paramIBinder).a());
    if ((!zok.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!zok.a(this.a).isEmpty())
    {
      this.a.a = ((zuy)zok.a(this.a).get(0));
      zok.a(this.a).remove(0);
      zok.a(this.a).a(this.a.a.a, this.a.a.b);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zok.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zom
 * JD-Core Version:    0.7.0.1
 */
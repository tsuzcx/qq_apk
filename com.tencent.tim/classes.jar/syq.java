import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.device.qfind.BluetoothLeService.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class syq
  implements ServiceConnection
{
  syq(syo paramsyo) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    syo.a(this.b, ((BluetoothLeService.a)paramIBinder).a());
    if ((!syo.a(this.b).initialize()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!syo.a(this.b).isEmpty())
    {
      this.b.a = ((tai)syo.a(this.b).get(0));
      syo.a(this.b).remove(0);
      syo.a(this.b).h(this.b.a.bAA, this.b.a.address);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    syo.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     syq
 * JD-Core Version:    0.7.0.1
 */
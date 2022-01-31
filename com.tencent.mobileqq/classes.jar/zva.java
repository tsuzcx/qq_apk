import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.qfind.QFindBLEScanMgr.3.1;
import mqq.os.MqqHandler;

public class zva
  implements BluetoothAdapter.LeScanCallback
{
  public zva(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.a != null) {
      this.a.a.post(new QFindBLEScanMgr.3.1(this, paramBluetoothDevice, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zva
 * JD-Core Version:    0.7.0.1
 */
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.qfind.QFindBLEScanMgr.3.1;
import mqq.os.MqqHandler;

public class tak
  implements BluetoothAdapter.LeScanCallback
{
  public tak(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.this$0.m != null) {
      this.this$0.m.post(new QFindBLEScanMgr.3.1(this, paramBluetoothDevice, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tak
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.qfind.QFindBLEScanMgr.ScanReceiver.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ygl
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr alarm is coming " + paramIntent.getAction());
    }
    if ((this.a.a == null) || (System.currentTimeMillis() - QFindBLEScanMgr.a(this.a) < this.a.h)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr startScan");
    }
    this.a.a.post(new QFindBLEScanMgr.ScanReceiver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */
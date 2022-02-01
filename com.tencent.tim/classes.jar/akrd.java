import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class akrd
  extends QQBroadcastReceiver
{
  public akrd(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramAppRuntime = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, new Object[] { "onReceive, action=", paramAppRuntime });
      }
    } while (!"com.tencent.tim__alive".equals(paramAppRuntime));
    ScanTorchActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrd
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;
import com.tencent.qphone.base.util.QLog;

public class xah
  extends BroadcastReceiver
{
  private xah(PayCodeEntryActivity paramPayCodeEntryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (paramContext.length() == 0)) {}
    while (!paramContext.equals("wlx.plugin.paycode.enterpage.exit")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayCodeEntryActivity", 2, "receive broadcast, exit paycode entry activity");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xah
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vlf
  extends BroadcastReceiver
{
  public vlf(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getAction();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.equals((CharSequence)localObject, "mqq.intent.action.DEVLOCK_ROAM")));
      if (paramContext != null) {
        paramContext.unregisterReceiver(this);
      }
      Object localObject = afrz.a();
      if (paramIntent.getIntExtra("guardphone_state", afrz.cTF) == afrz.cTE)
      {
        paramIntent = paramIntent.getStringExtra("guardphone_mask");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = "";
        }
        QLog.i("IphoneTitleBarActivity", 1, "mDevlockBroadcastReceiver, showAlertDialog");
        ((afrz)localObject).E(this.a, paramContext);
        return;
      }
      this.a.a.bpb = true;
      QLog.i("IphoneTitleBarActivity", 1, "mDevlockBroadcastReceiver, refreshServerData");
    } while ((acll)this.a.app.getBusinessHandler(34) == null);
    this.a.app.addObserver(this.a.c);
    this.a.n(4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlf
 * JD-Core Version:    0.7.0.1
 */
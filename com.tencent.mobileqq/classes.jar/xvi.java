import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.qphone.base.util.QLog;

public class xvi
  extends BroadcastReceiver
{
  public xvi(DeviceTipActivity paramDeviceTipActivity) {}
  
  @TargetApi(12)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey"))) {
        this.a.finish();
      }
    }
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if (paramContext.equals("android.intent.action.SCREEN_OFF"))
          {
            baan.a();
            return;
          }
          if (paramContext.equals("android.intent.action.SCREEN_ON"))
          {
            baan.a(2131230742, -1, null);
            return;
          }
          if (!paramContext.equals("SmartDevice_receiveDPMsg")) {
            break;
          }
        } while ((DataPoint)paramIntent.getExtras().getParcelable("dataPoint") != null);
        return;
      } while (!paramContext.equals("On_OccupyMicrophoneNotify_Push"));
      if (QLog.isColorLevel()) {
        QLog.d(DeviceTipActivity.a, 2, "DeviceTipActivity intent.getExtras() : " + paramIntent.getExtras());
      }
      paramContext = paramIntent.getExtras();
      l = paramContext.getLong("din", 0L);
      paramContext = paramContext.getString("uin", "");
    } while ((!this.a.b.equals(String.valueOf(Long.valueOf(l)))) || (TextUtils.isEmpty(paramContext)));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xvi
 * JD-Core Version:    0.7.0.1
 */
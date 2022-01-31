import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ble
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  public ble(VideoInviteLock paramVideoInviteLock) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        this.a.b();
        if (!this.a.b) {
          break label92;
        }
        ReportController.b(null, "CliOper", "", "", "0X80041FF", "0X80041FF", 0, 0, Integer.toString(this.a.d), Integer.toString(this.a.f), "", "");
      }
    }
    for (;;)
    {
      return;
      label92:
      ReportController.b(null, "CliOper", "", "", "0X8004203", "0X8004203", 0, 0, Integer.toString(this.a.d), Integer.toString(this.a.f), "", "");
      return;
      if (paramContext.equals("tencent.notify.cancel.videorequest"))
      {
        paramContext = paramIntent.getStringExtra("selfUin");
        paramIntent = paramIntent.getStringExtra("sendUin");
        if (QLog.isColorLevel()) {
          QLog.d(VideoInviteLock.g, 2, "recv cancel video request");
        }
        if ((this.a.a.a() == null) || ((this.a.a.a().equals(paramContext)) && (paramIntent.equals(this.a.c)))) {
          this.a.finish();
        }
      }
      else if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        if (this.a.b) {
          ReportController.b(null, "CliOper", "", "", "0X8004208", "0X8004208", 0, 0, Integer.toString(this.a.d), Integer.toString(this.a.f), "", "");
        }
        while (QLog.isColorLevel())
        {
          QLog.d(VideoInviteLock.g, 2, "ACTION_SCREEN_OFF");
          return;
          ReportController.b(null, "CliOper", "", "", "0X8004209", "0X8004209", 0, 0, Integer.toString(this.a.d), Integer.toString(this.a.f), "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ble
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class bhv
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  public bhv(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        ReportController.b(null, "CliOper", "", "", "0X8004210", "0X8004210", 0, 0, "", "", "", "");
        this.a.g();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramContext.equals("tencent.notify.cancel.videorequest")) {
            break;
          }
          paramContext = paramIntent.getStringExtra("selfUin");
          paramIntent = paramIntent.getStringExtra("sendUin");
          if (QLog.isColorLevel()) {
            QLog.d(GaInviteLockActivity.b, 2, "recv cancel audio request");
          }
        } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null) && ((!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(paramContext)) || (!paramIntent.equals(Long.valueOf(this.a.jdField_a_of_type_Long)))));
        this.a.finish();
        return;
      } while (!paramContext.equals("android.intent.action.SCREEN_OFF"));
      ReportController.b(null, "CliOper", "", "", "0X800420C", "0X800420C", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d(GaInviteLockActivity.b, 2, "ACTION_SCREEN_OFF");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhv
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.QQGlRender;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bix
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  public bix(AVActivity paramAVActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
      {
        if (!paramContext.equals("homekey")) {
          break label125;
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a == 4)
        {
          if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().e) {
            break label100;
          }
          ReportController.b(null, "CliOper", "", "", "0X80041BB", "0X80041BB", 0, 0, "", "", "", "");
        }
      }
    }
    label100:
    label125:
    while ((!paramContext.equals(QQGlRender.SHOW1STFRAME_BROADCAST)) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null))
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80041BE", "0X80041BE", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(84) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bix
 * JD-Core Version:    0.7.0.1
 */
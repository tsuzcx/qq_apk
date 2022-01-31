import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class bld
  extends BroadcastReceiver
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "reason";
  public static final int b = 1;
  static final String b = "homekey";
  public static final int c = 2;
  static final String c = "rencentkeys";
  private int d = -1;
  
  public bld(VideoInviteFull paramVideoInviteFull, int paramInt)
  {
    this.d = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    switch (this.d)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (!paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
          paramContext = paramIntent.getStringExtra("reason");
        } while ((paramContext == null) || (!paramContext.equals("homekey")));
        if (this.a.b)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004399", "0X8004399", 0, 0, Integer.toString(this.a.d), Integer.toString(this.a.jdField_f_of_type_Int), "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X80043F8", "0X80043F8", 0, 0, Integer.toString(this.a.d), Integer.toString(this.a.jdField_f_of_type_Int), "", "");
        return;
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      paramContext = new Intent(this.a, VideoInviteLock.class);
      paramContext.addFlags(268435456);
      paramContext.putExtra("uinType", this.a.e);
      paramContext.putExtra("peerUin", this.a.c);
      paramContext.putExtra("isAudioMode", this.a.b);
      paramContext.putExtra("curUserStatus", this.a.d);
      paramContext.putExtra("powerKey", true);
      this.a.startActivity(paramContext);
      this.a.finish();
      this.a.jdField_f_of_type_Boolean = true;
      return;
      paramContext = paramIntent.getStringExtra("selfUin");
      paramIntent = paramIntent.getStringExtra("sendUin");
      if (QLog.isColorLevel()) {
        QLog.d(VideoInviteFull.g, 2, "recv cancel video request");
      }
    } while ((this.a.a.a() != null) && ((!this.a.a.a().equals(paramContext)) || (!paramIntent.equals(this.a.c))));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bld
 * JD-Core Version:    0.7.0.1
 */
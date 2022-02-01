import com.tencent.commonsdk.util.notification.NotificationLimiter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.qphone.base.util.QLog;

public class aurz
  implements NotificationLimiter
{
  private boolean nc(int paramInt)
  {
    return (paramInt == 241) || (paramInt == 244) || (paramInt == 242) || (paramInt == 243);
  }
  
  private boolean nd(int paramInt)
  {
    return (paramInt >= 528) && (paramInt <= 3000528);
  }
  
  public boolean shouldNotify(int paramInt)
  {
    if (nc(paramInt)) {}
    while (nd(paramInt)) {
      return true;
    }
    boolean bool1;
    if (znx.a().Vx())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NotificationLimiterImpl", 2, "MINI PROC FORE");
      }
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1) {
        if (anwa.lK(paramInt)) {
          break label113;
        }
      }
      label113:
      for (bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationLimiterImpl", 2, String.format("studymode_fightNotificationLimiterImpl ,shouldNotify1 = %b,", new Object[] { Boolean.valueOf(bool2) }));
        }
        return bool2;
        if (!MiniChatActivity.Vw()) {
          break label118;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NotificationLimiterImpl", 2, "MiniMsgActForeGround");
        }
        bool1 = false;
        break;
      }
      label118:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aurz
 * JD-Core Version:    0.7.0.1
 */
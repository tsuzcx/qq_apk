import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class anwj
  extends BroadcastReceiver
{
  anwj(anwh paramanwh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      if ((paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) || (paramContext.equals("mqq.intent.action.LOGOUT")))
      {
        if (QLog.isColorLevel()) {
          QLog.e("studyroom.StudyRoomManager", 2, "***exitProcexx*** receive broacast action=" + paramIntent.getAction());
        }
        anwh.a(this.a).exitProcess(false);
        return;
      }
    } while (!paramContext.equals("mqq.intent.action.EXIT_" + MobileQQ.getContext().getPackageName()));
    if (QLog.isColorLevel()) {
      QLog.e("studyroom.StudyRoomManager", 2, "***exitProcexx*** receive broacast action=" + paramIntent.getAction());
    }
    anwh.a(this.a).exitProcess(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwj
 * JD-Core Version:    0.7.0.1
 */
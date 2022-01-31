import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class cgk
  implements DialogInterface.OnClickListener
{
  public cgk(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("devlock", 4, "left button is clicked! ");
    }
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.a.b.a(), "UserBehavior", "Push", 0, 4, "", "", "", "");
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgk
 * JD-Core Version:    0.7.0.1
 */
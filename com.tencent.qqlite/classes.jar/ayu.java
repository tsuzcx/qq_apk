import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class ayu
  implements DialogInterface.OnClickListener
{
  public ayu(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.b().post(new ayv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ayu
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity;
import com.tencent.qphone.base.util.QLog;

public class wqt
  extends BroadcastReceiver
{
  public wqt(ConfessHalfScreenActivity paramConfessHalfScreenActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "Confess finish action! ");
      }
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqt
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class aqyd
  extends BroadcastReceiver
{
  public aqyd(WebProcessManager paramWebProcessManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "action=" + paramContext);
        }
        if (!paramContext.equals("com.tencent.mobileqq.webprocess.restart_web_process")) {
          break;
        }
        this.this$0.egv();
      } while (!paramIntent.getBooleanExtra("isPreloadWebProcess", false));
      this.this$0.aca();
      return;
    } while (!paramContext.equals("com.tencent.mobileqq.webprocess.report"));
    this.this$0.aca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyd
 * JD-Core Version:    0.7.0.1
 */
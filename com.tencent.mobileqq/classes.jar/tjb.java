import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class tjb
  implements Runnable
{
  public tjb(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    Object localObject1 = (ActivityManager)this.a.getSystemService("activity");
    try
    {
      Object localObject2 = ((ActivityManager)localObject1).getRunningTasks(1);
      localObject1 = AppSetting.b;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((ActivityManager.RunningTaskInfo)((List)localObject2).get(0)).topActivity.getClassName();
        boolean bool = QQLSActivity.e(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "qqlsActivity onpause by :" + (String)localObject2);
        }
        if ((((String)localObject2).equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity")) && (bool))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
          }
          if (QQLSActivity.a(this.a).hasMessages(10)) {
            QQLSActivity.a(this.a).removeMessages(10);
          }
          localObject2 = QQLSActivity.a(this.a).obtainMessage(10);
          if (((String)localObject1).equalsIgnoreCase("Xiaomi-2013022"))
          {
            QQLSActivity.a(this.a).sendMessageDelayed((Message)localObject2, 600L);
            return;
          }
          QQLSActivity.a(this.a).sendMessage((Message)localObject2);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "qqlsActivity MSG_SETTO_FRONT by locking activity not to front e=" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjb
 * JD-Core Version:    0.7.0.1
 */
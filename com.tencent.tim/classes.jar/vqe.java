import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.WebPreloadTask;
import com.tencent.mobileqq.webprocess.WebProcessManager.a;
import com.tencent.qphone.base.util.QLog;

public class vqe
  implements WebProcessManager.a
{
  public vqe(QQSettingMe.WebPreloadTask paramWebPreloadTask, QQSettingMe paramQQSettingMe) {}
  
  public void onResult(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQSettingMe.a(this.b) != null)) {
      QQSettingMe.a(this.b).begin();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("WebPreloadTask preloadWebProcess isProcessExist: ");
      if (paramBoolean) {
        break label64;
      }
    }
    label64:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQSettingRedesign", 2, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqe
 * JD-Core Version:    0.7.0.1
 */
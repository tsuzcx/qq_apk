import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class tib
  implements Runnable
{
  public tib(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (this.a.a == null) {}
    String str;
    do
    {
      return;
      str = this.a.a.getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.b(str, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tib
 * JD-Core Version:    0.7.0.1
 */
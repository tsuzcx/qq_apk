import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

public class zsb
  implements Runnable
{
  public zsb(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!QQAppInterface.a(this.a).verifyAuthentication())
    {
      QLog.e("QQAppInterface", 1, "", new RuntimeException("WTF"));
      if (this.a.isLogin()) {
        this.a.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", "登录失败");
      localIntent.putExtra("msg", "登录失败");
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.sApplication.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsb
 * JD-Core Version:    0.7.0.1
 */
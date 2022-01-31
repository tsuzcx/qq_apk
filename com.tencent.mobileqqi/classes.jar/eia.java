import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.PrivacyDeclareHelper.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;

public class eia
  implements PrivacyDeclareHelper.Callback
{
  public eia(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Barry", 2, "in 16-UP to privacy page, user reject");
    }
    MainAssistObserver.a(this.a);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Barry", 2, "in 16-UP to privacy page, user FinishSelf");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Barry", 2, "in 16-UP to privacy page, user confirm");
    }
    EUCountryUtils.a(this.a.a.b.a(), 1);
    EUCountryUtils.b(this.a.a.b.a(), 1);
    MainAssistObserver.a(this.a, 0);
    MainAssistObserver.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eia
 * JD-Core Version:    0.7.0.1
 */
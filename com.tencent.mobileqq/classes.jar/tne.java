import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class tne
  extends AccountObserver
{
  public tne(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginFailed ");
    }
    RegisterQQNumberActivity.a(this.a);
    paramString1 = new Intent(this.a, LoginActivity.class);
    paramString1.putExtra("uin", RegisterQQNumberActivity.a(this.a));
    paramString1.putExtra("tab_index", MainFragment.a);
    paramString1.addFlags(131072);
    this.a.startActivity(paramString1);
    this.a.finish();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    super.onLoginSuccess(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  protected void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginTimeout ");
    }
  }
  
  protected void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tne
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class vro
  extends AccountObserver
{
  public vro(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "AccountObserver ,onLoginFailed ");
    }
    RegisterChooseLoginActivity.a(this.a);
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    super.onLoginSuccess(paramString1, paramString2, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "AccountObserver ,onLoginTimeout ");
    }
    RegisterChooseLoginActivity.a(this.a);
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "AccountObserver ,onUserCancel ");
    }
    RegisterChooseLoginActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vro
 * JD-Core Version:    0.7.0.1
 */
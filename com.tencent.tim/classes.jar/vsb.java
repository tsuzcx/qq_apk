import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity.4.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

public class vsb
  extends AccountObserver
{
  public vsb(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt1), RegisterQQNumberActivity.a(this.this$0), paramString2, paramString1 }));
    }
    RegisterQQNumberActivity.a(this.this$0);
    paramString1 = new Intent(this.this$0, LoginActivity.class);
    paramString1.putExtra("uin", RegisterQQNumberActivity.a(this.this$0));
    paramString1.putExtra("tab_index", MainFragment.bIk);
    paramString1.addFlags(131072);
    this.this$0.startActivity(paramString1);
    this.this$0.finish();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    super.onLoginSuccess(paramString1, paramString2, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginTimeout ");
    }
    RegisterQQNumberActivity.a(this.this$0);
    this.this$0.handler.post(new RegisterQQNumberActivity.4.1(this));
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsb
 * JD-Core Version:    0.7.0.1
 */
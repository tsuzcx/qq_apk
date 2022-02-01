import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.AutoLoginHelper.4.1;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

public class uhy
  extends AccountObserver
{
  uhy(uhv paramuhv) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt1), uhv.a(this.this$0), paramString2, paramString1 }));
    }
    this.this$0.isLogining = false;
    uhv.a(this.this$0);
    if (uhv.a(this.this$0) != null)
    {
      paramString1 = new Intent(uhv.a(this.this$0), LoginActivity.class);
      paramString1.putExtra("uin", uhv.a(this.this$0));
      paramString1.putExtra("tab_index", MainFragment.bIk);
      paramString1.addFlags(131072);
      uhv.a(this.this$0).startActivity(paramString1);
      uhv.a(this.this$0).finish();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    super.onLoginSuccess(paramString1, paramString2, paramArrayOfByte);
    this.this$0.isLogining = false;
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onLoginTimeout ");
    }
    this.this$0.isLogining = false;
    uhv.a(this.this$0);
    uhv.a(this.this$0).handler.post(new AutoLoginHelper.4.1(this));
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    this.this$0.isLogining = false;
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhy
 * JD-Core Version:    0.7.0.1
 */
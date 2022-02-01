import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class akrt
  extends aktr
{
  public akrt(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void Nf(boolean paramBoolean)
  {
    super.Nf(paramBoolean);
    if ((AccountOnlineStateActivity.a(this.this$0) == AppRuntime.Status.online) && (AccountOnlineStateActivity.a(this.this$0) == -1L)) {
      AccountOnlineStateActivity.b(this.this$0);
    }
  }
  
  public void V(boolean paramBoolean, Bundle paramBundle)
  {
    super.V(paramBoolean, paramBundle);
    if (paramBoolean) {
      AccountOnlineStateActivity.a(this.this$0, true);
    }
  }
  
  public void s(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, new Object[] { "onSetOnlineStatus, isSuccess: ", Boolean.valueOf(paramBoolean), " , mIsUpdateStatus: ", Boolean.valueOf(AccountOnlineStateActivity.a(this.this$0)) });
    }
    if (AccountOnlineStateActivity.a(this.this$0))
    {
      AccountOnlineStateActivity.a(this.this$0, false);
      if (paramBoolean) {
        AccountOnlineStateActivity.a(this.this$0, true, 0);
      }
    }
    else
    {
      return;
    }
    AccountOnlineStateActivity.a(this.this$0, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrt
 * JD-Core Version:    0.7.0.1
 */
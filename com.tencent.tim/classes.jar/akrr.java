import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class akrr
  extends AccountObserver
{
  public akrr(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onOnlineStatusChanged, isSuccess: " + paramBoolean1 + " , mIsUpdateStatus: " + AccountOnlineStateActivity.a(this.this$0) + ", isUserSet: " + paramBoolean2);
    }
    if (AccountOnlineStateActivity.a(this.this$0))
    {
      AccountOnlineStateActivity.a(this.this$0, false);
      if (paramBoolean1) {
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
 * Qualified Name:     akrr
 * JD-Core Version:    0.7.0.1
 */
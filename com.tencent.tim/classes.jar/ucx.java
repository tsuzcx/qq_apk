import com.tencent.mobileqq.activity.AccountManageActivity;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class ucx
  extends AccountObserver
{
  public ucx(AccountManageActivity paramAccountManageActivity) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    AccountManageActivity.b(this.this$0);
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    AccountManageActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucx
 * JD-Core Version:    0.7.0.1
 */
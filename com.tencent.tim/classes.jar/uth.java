import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class uth
  extends AccountObserver
{
  public uth(Conversation paramConversation) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (this.this$0.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, String.format("onOnlineStatusChanged, currentStatus = %s", new Object[] { paramStatus }));
      }
      this.this$0.a.mUiHandler.sendEmptyMessage(18);
    }
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, String.format("onOnlineStatusPush, currentStatus = %s , extOnlineStatus = %d", new Object[] { paramStatus, Long.valueOf(paramLong) }));
    }
    this.this$0.a.mUiHandler.sendEmptyMessage(18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uth
 * JD-Core Version:    0.7.0.1
 */
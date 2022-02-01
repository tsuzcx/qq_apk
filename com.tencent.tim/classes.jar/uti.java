import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;

public class uti
  extends aktr
{
  public uti(Conversation paramConversation) {}
  
  public void s(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.this$0.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "onSetOnlineStatus, isSuccess", Boolean.valueOf(paramBoolean) });
      }
      this.this$0.a.mUiHandler.sendEmptyMessage(18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uti
 * JD-Core Version:    0.7.0.1
 */
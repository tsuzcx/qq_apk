import android.app.Activity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;

public class ytj
  extends yqy
{
  public ytj(SystemMsgListView paramSystemMsgListView) {}
  
  protected void ak(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onRefreshBlockedEntrance");
    }
    if (((Activity)SystemMsgListView.a(this.this$0)).isFinishing()) {}
    while ((!paramBoolean) || (SystemMsgListView.a(this.this$0) == null)) {
      return;
    }
    SystemMsgListView.a(this.this$0).refreshData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytj
 * JD-Core Version:    0.7.0.1
 */
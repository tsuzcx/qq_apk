import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class vee
  extends acfd
{
  public vee(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString = ((acff)this.this$0.app.getManager(51)).e(this.this$0.mOwnerUin + "");
      if (paramString != null)
      {
        this.this$0.mOwnerName = paramString.name;
        JoinDiscussionActivity.a(this.this$0);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("IphoneTitleBarActivity", 2, "get owner name failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vee
 * JD-Core Version:    0.7.0.1
 */
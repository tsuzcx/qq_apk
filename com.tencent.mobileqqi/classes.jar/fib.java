import android.os.Bundle;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

public class fib
  extends FriendListObserver
{
  public fib(MessageHandler paramMessageHandler) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateAnswerAddedFriend isSuccess = " + paramBoolean + ", uin = " + paramString + ", flag = " + paramInt);
    }
    if (paramBoolean) {
      this.a.a.a().o();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateFriendList isSuccess = " + paramBoolean1 + ", isComplete = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a.a().o();
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBoolean)) {
      return;
    }
    String str = paramBundle.getString("uin");
    int i = paramBundle.getInt("resultCode");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdateAddFriend isSuccess = ");
      if (i != 0) {
        break label141;
      }
    }
    label141:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("Q.msg.MessageHandler", 2, paramBoolean + ", uin = " + str);
      int j = paramBundle.getInt("source_id");
      paramBoolean = paramBundle.getBoolean("contact_bothway");
      int k = paramBundle.getInt("friend_setting");
      if ((i != 0) || (!AutoRemarkActivity.a(k, j, paramBoolean)) || (str == null) || (str.length() <= 4)) {
        break;
      }
      this.a.a.a().o();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fib
 * JD-Core Version:    0.7.0.1
 */
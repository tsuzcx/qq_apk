import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;

public class byf
  implements Runnable
{
  public byf(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    new byg(this).execute(new Void[0]);
    if ((this.a.getIntent().getExtras().containsKey("forward_type")) && (this.a.a.a != null) && (this.a.a.a.equals(this.a.getIntent().getStringExtra("uin")))) {}
    for (int i = 1;; i = 0)
    {
      FriendManager localFriendManager = (FriendManager)this.a.b.getManager(8);
      boolean bool = localFriendManager.f(this.a.a.a);
      if ((TroopRemindSettingManager.a().a(this.a.a.a, this.a.b)) && (!bool))
      {
        ChatActivityUtils.a(this.a, this.a.getString(2131562215), 3000L);
        TroopRemindSettingManager.a().a(this.a.a.a, this.a.b);
      }
      if ((i == 0) && (this.a.b.b(this.a.a.a) == 3) && (!bool)) {
        ChatActivityUtils.a(this.a, this.a.getString(2131563267), 3000L);
      }
      if (bool) {
        localFriendManager.g(this.a.a.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byf
 * JD-Core Version:    0.7.0.1
 */
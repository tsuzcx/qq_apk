import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class cnk
  implements Runnable
{
  public cnk(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if (FriendProfileCardActivity.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig currentCardTemplate=" + FriendProfileCardActivity.a(this.a).toString());
      }
      if (FriendProfileCardActivity.a(this.a).a(this.a.b))
      {
        localMessage = this.a.a.obtainMessage(8);
        if (QLog.isColorLevel())
        {
          if ((FriendProfileCardActivity.a(this.a) == null) || (FriendProfileCardActivity.a(this.a).a == null)) {
            break label192;
          }
          i = FriendProfileCardActivity.a(this.a).a.size();
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig result=" + localMessage.what + ",templateAttr size=" + i);
        }
        this.a.a.sendMessage(localMessage);
      }
    }
    label192:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        Message localMessage = this.a.a.obtainMessage(9);
        continue;
        int i = 0;
      }
    }
    QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig currentCardTemplate is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnk
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class aoq
  extends BroadcastReceiver
{
  public aoq(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.a.a.a.equals(this.a.app.a())) && (FriendProfileCardActivity.a(this.a) != null)) {
      FriendProfileCardActivity.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aoq
 * JD-Core Version:    0.7.0.1
 */
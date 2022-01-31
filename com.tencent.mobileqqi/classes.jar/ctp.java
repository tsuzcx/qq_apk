import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class ctp
  extends BroadcastReceiver
{
  public ctp(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.a.a.a.equals(this.a.b.a())) && (FriendProfileCardActivity.a(this.a) != null)) {
      FriendProfileCardActivity.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ctp
 * JD-Core Version:    0.7.0.1
 */
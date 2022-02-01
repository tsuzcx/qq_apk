import android.content.Intent;
import com.tencent.mobileqq.app.TroopManager.g;
import com.tencent.tim.activity.profile.friend.FriendProfileFragment;

public class atbu
  implements TroopManager.g
{
  public atbu(FriendProfileFragment paramFriendProfileFragment, Intent paramIntent) {}
  
  public void onResult(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.B.putExtra("troop_uin", (String)paramObject);
      this.B.putExtra("cSpecialFlag", 0);
      this.a.startActivity(this.B);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbu
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.TroopManager.g;

public class vac
  implements TroopManager.g
{
  public vac(FriendProfileCardActivity paramFriendProfileCardActivity, Intent paramIntent) {}
  
  public void onResult(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.B.putExtra("troop_uin", (String)paramObject);
      this.B.putExtra("cSpecialFlag", 0);
      this.this$0.startActivity(this.B);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vac
 * JD-Core Version:    0.7.0.1
 */
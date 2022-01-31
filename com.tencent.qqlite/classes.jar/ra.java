import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.FriendListObserver;

public class ra
  extends FriendListObserver
{
  public ra(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void c(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 30);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(2));
    this.a.a(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ra
 * JD-Core Version:    0.7.0.1
 */
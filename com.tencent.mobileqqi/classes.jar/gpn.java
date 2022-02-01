import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity.TroopAdapter;

public class gpn
  extends FriendListObserver
{
  public gpn(FavOpenTroopActivity paramFavOpenTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gpn
 * JD-Core Version:    0.7.0.1
 */
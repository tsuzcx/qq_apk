import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity.TroopAdapter;

public class eib
  extends FriendListObserver
{
  public eib(FavOpenTroopActivity paramFavOpenTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eib
 * JD-Core Version:    0.7.0.1
 */
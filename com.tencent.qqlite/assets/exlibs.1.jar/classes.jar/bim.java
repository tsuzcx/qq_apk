import com.tencent.mobileqq.activity.SearchFriendListActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class bim
  extends FriendListObserver
{
  public bim(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      SearchFriendListActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null)) {
      SearchFriendListActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bim
 * JD-Core Version:    0.7.0.1
 */
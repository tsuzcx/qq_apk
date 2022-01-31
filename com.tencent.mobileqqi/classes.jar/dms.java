import com.tencent.mobileqq.activity.SearchFriendListActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class dms
  extends FriendListObserver
{
  public dms(SearchFriendListActivity paramSearchFriendListActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dms
 * JD-Core Version:    0.7.0.1
 */
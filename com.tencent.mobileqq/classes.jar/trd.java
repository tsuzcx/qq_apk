import com.tencent.mobileqq.activity.SearchFriendListActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class trd
  extends FriendListObserver
{
  public trd(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      SearchFriendListActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null)) {
      SearchFriendListActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trd
 * JD-Core Version:    0.7.0.1
 */
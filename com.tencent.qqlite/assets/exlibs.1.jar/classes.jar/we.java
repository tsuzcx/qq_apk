import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class we
  extends FriendListObserver
{
  public we(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     we
 * JD-Core Version:    0.7.0.1
 */
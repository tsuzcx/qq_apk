import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class bzg
  extends FriendListObserver
{
  public bzg(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bzg
 * JD-Core Version:    0.7.0.1
 */
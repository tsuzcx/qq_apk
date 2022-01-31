import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class chv
  extends FriendListObserver
{
  public chv(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chv
 * JD-Core Version:    0.7.0.1
 */
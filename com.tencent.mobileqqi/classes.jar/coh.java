import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class coh
  extends FriendListObserver
{
  public coh(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     coh
 * JD-Core Version:    0.7.0.1
 */
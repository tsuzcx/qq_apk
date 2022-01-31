import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class aji
  extends FriendListObserver
{
  public aji(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aji
 * JD-Core Version:    0.7.0.1
 */
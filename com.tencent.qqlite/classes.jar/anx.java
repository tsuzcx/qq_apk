import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class anx
  extends FriendListObserver
{
  public anx(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      ForwardRecentActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anx
 * JD-Core Version:    0.7.0.1
 */
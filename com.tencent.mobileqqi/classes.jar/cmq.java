import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class cmq
  extends FriendListObserver
{
  public cmq(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      ForwardRecentActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmq
 * JD-Core Version:    0.7.0.1
 */
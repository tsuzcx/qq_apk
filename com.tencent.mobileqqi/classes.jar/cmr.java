import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class cmr
  extends FriendListObserver
{
  public cmr(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      ForwardRecentActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmr
 * JD-Core Version:    0.7.0.1
 */
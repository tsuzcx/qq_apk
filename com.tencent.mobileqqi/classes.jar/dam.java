import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class dam
  extends FriendListObserver
{
  public dam(PublicAccountActivity paramPublicAccountActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      PublicAccountActivity.a(this.a).sendEmptyMessageDelayed(3, 1200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dam
 * JD-Core Version:    0.7.0.1
 */
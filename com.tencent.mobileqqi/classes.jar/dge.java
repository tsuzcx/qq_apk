import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class dge
  extends FriendListObserver
{
  public dge(PublicAccountActivity paramPublicAccountActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      PublicAccountActivity.a(this.a).sendEmptyMessageDelayed(3, 1200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dge
 * JD-Core Version:    0.7.0.1
 */
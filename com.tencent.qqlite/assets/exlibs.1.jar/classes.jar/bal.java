import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bal
  extends FriendListObserver
{
  public bal(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(2131364023, 1);
    }
    PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean2);
  }
  
  protected void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bal
 * JD-Core Version:    0.7.0.1
 */
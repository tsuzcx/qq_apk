import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class wsa
  extends ContactBindObserver
{
  public wsa(PhoneMatchActivity paramPhoneMatchActivity) {}
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    this.a.b();
    if (paramBoolean)
    {
      this.a.finish();
      return;
    }
    this.a.b("更新失败，请稍后重试。");
  }
  
  protected void e(boolean paramBoolean, int paramInt)
  {
    this.a.b();
    if (paramBoolean)
    {
      ContactBindedActivity.a(this.a.app, 222);
      this.a.finish();
      return;
    }
    this.a.b("更新失败，请稍后重试。");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */
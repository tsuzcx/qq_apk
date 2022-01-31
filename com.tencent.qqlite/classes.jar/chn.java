import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class chn
  extends ContactBindObserver
{
  public chn(PhoneMatchActivity paramPhoneMatchActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.a != null)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
    }
    this.a.d();
    if (paramBoolean)
    {
      if (this.a.a != null)
      {
        this.a.app.unRegistObserver(this.a.a);
        this.a.a = null;
      }
      this.a.finish();
      return;
    }
    this.a.a("更新失败，请稍后重试。");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chn
 * JD-Core Version:    0.7.0.1
 */
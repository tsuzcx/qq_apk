import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class elp
  extends ContactBindObserver
{
  public elp(PhoneMatchActivity paramPhoneMatchActivity) {}
  
  protected void b(boolean paramBoolean)
  {
    if (this.a.a != null)
    {
      this.a.b.unRegistObserver(this.a.a);
      this.a.a = null;
    }
    this.a.d();
    if (paramBoolean)
    {
      if (this.a.a != null)
      {
        this.a.b.unRegistObserver(this.a.a);
        this.a.a = null;
      }
      this.a.finish();
      return;
    }
    this.a.b(2131558979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elp
 * JD-Core Version:    0.7.0.1
 */
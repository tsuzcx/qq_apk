import com.tencent.mobileqq.activity.phone.BaseActivityView.IPhoneContext;
import com.tencent.mobileqq.activity.phone.PhoneInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class wvb
  extends ContactBindObserver
{
  public wvb(PhoneInnerFrame paramPhoneInnerFrame) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.a)
    {
      this.a.b().a().unRegistObserver(this);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvb
 * JD-Core Version:    0.7.0.1
 */
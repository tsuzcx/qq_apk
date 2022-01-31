import com.tencent.mobileqq.activity.phone.BaseActivityView.IPhoneContext;
import com.tencent.mobileqq.activity.phone.PhoneInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class chs
  extends ContactBindObserver
{
  public chs(PhoneInnerFrame paramPhoneInnerFrame) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a.a)
    {
      this.a.b().a().unRegistObserver(this);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chs
 * JD-Core Version:    0.7.0.1
 */
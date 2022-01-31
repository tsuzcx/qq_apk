import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class ygc
  extends ContactBindObserver
{
  public ygc(PhoneContactTabView paramPhoneContactTabView) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    switch (PhoneContactTabView.a(this.a).c())
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      PhoneContactTabView.b(this.a);
      return;
    case 9: 
      this.a.d();
      return;
    case 0: 
    case 1: 
    case 5: 
    case 7: 
      PhoneContactTabView.a(this.a);
      return;
    }
    if (PhoneContactTabView.a(this.a).a().lastUsedFlag == 2L)
    {
      this.a.d();
      return;
    }
    PhoneContactTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygc
 * JD-Core Version:    0.7.0.1
 */
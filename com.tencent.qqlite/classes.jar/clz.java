import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class clz
  extends ContactBindObserver
{
  public clz(ContactsInnerFrame paramContactsInnerFrame) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.a.unRegistObserver(this);
    this.a.c = ContactsInnerFrame.a(this.a).b();
    switch (this.a.c)
    {
    case 5: 
    case 6: 
    default: 
      ContactsInnerFrame.c(this.a);
      return;
    case 0: 
    case 4: 
    case 7: 
      ContactsInnerFrame.a(this.a);
      return;
    case 1: 
    case 2: 
      ContactsInnerFrame.b(this.a);
      return;
    }
    if (ContactsInnerFrame.a(this.a).a().lastUsedFlag == 2L)
    {
      ContactsInnerFrame.a(this.a);
      return;
    }
    ContactsInnerFrame.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clz
 * JD-Core Version:    0.7.0.1
 */
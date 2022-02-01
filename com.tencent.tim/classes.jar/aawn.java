import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;

public class aawn
  extends akwl
{
  public aawn(ContactsInnerFrame paramContactsInnerFrame) {}
  
  protected void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.e.unRegistObserver(this);
    switch (ContactsInnerFrame.a(this.a).xy())
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      ContactsInnerFrame.c(this.a);
      return;
    case 0: 
    case 7: 
    case 9: 
      ContactsInnerFrame.a(this.a);
      return;
    case 1: 
    case 5: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawn
 * JD-Core Version:    0.7.0.1
 */
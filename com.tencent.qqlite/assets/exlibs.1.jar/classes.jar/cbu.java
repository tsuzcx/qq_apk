import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

public class cbu
  implements ConditionSearchManager.IConfigListener
{
  public cbu(AddContactsView paramAddContactsView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean))
    {
      this.a.b = true;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbu
 * JD-Core Version:    0.7.0.1
 */
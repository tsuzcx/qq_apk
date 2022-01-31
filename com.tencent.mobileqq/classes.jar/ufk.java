import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class ufk
  extends ContactBindObserver
{
  public ufk(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufk
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class uke
  extends ContactBindObserver
{
  public uke(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
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
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */
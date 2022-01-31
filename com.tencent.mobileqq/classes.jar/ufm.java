import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import java.util.List;

public class ufm
  extends FriendListObserver
{
  public ufm(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
      return;
    }
    this.a.a(2131437762, 1);
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a(2131433261, 2);
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean3))
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufm
 * JD-Core Version:    0.7.0.1
 */
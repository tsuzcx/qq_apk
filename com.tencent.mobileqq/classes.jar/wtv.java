import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.FriendListObserver;

public class wtv
  extends FriendListObserver
{
  public wtv(ContactListView paramContactListView) {}
  
  protected void onAddFriend(String paramString) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (!paramBoolean3)) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtv
 * JD-Core Version:    0.7.0.1
 */
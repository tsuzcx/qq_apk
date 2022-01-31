import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.FriendListObserver;

public class cgi
  extends FriendListObserver
{
  public cgi(ContactListView paramContactListView) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (!paramBoolean3)) {
      this.a.j();
    }
  }
  
  protected void a_(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgi
 * JD-Core Version:    0.7.0.1
 */
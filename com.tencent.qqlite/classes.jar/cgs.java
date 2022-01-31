import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.phone.ContactListView;

public class cgs
  implements DialogInterface.OnKeyListener
{
  public cgs(ContactListView paramContactListView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgs
 * JD-Core Version:    0.7.0.1
 */
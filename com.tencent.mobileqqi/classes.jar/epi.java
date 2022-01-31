import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.ContactListView;

public class epi
  implements DialogInterface.OnDismissListener
{
  public epi(ContactListView paramContactListView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ContactListView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     epi
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.ContactListView;

public class eku
  implements DialogInterface.OnDismissListener
{
  public eku(ContactListView paramContactListView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ContactListView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eku
 * JD-Core Version:    0.7.0.1
 */
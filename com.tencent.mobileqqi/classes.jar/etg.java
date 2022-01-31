import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;

public class etg
  implements DialogInterface.OnDismissListener
{
  public etg(VoipAddressBookView paramVoipAddressBookView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    VoipAddressBookView.a(this.a).setVisibility(0);
    VoipAddressBookView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etg
 * JD-Core Version:    0.7.0.1
 */
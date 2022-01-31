import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;

public class exu
  implements DialogInterface.OnDismissListener
{
  public exu(VoipAddressBookView paramVoipAddressBookView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    VoipAddressBookView.a(this.a).setVisibility(0);
    VoipAddressBookView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exu
 * JD-Core Version:    0.7.0.1
 */
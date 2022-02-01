import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.QQAppInterface;

public class eta
  implements DialogInterface.OnClickListener
{
  public eta(VoipAddressBookView paramVoipAddressBookView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VoipAddressBookView.b(this.a).a(new etb(this));
    VoipAddressBookView.k(this.a);
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eta
 * JD-Core Version:    0.7.0.1
 */
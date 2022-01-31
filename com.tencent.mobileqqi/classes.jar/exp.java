import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.app.QQAppInterface;

public class exp
  implements DialogInterface.OnClickListener
{
  public exp(VoipAddressBookView paramVoipAddressBookView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VoipAddressBookView.b(this.a).a(new exq(this));
    VoipAddressBookView.k(this.a);
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exp
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;

public class etd
  implements DialogInterface.OnKeyListener
{
  public etd(VoipAddressBookView paramVoipAddressBookView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      VoipAddressBookView.m(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etd
 * JD-Core Version:    0.7.0.1
 */
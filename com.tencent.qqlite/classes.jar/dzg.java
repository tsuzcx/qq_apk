import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

public class dzg
  implements DialogInterface.OnClickListener
{
  public dzg(PhoneNumLoginImpl paramPhoneNumLoginImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dzg
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class bif
  implements DialogInterface.OnClickListener
{
  public bif(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bif
 * JD-Core Version:    0.7.0.1
 */
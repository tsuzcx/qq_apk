import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class bic
  implements DialogInterface.OnClickListener
{
  public bic(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    RegisterSendUpSms.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bic
 * JD-Core Version:    0.7.0.1
 */
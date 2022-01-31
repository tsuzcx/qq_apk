import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterSendUpSms;

public class dmi
  implements DialogInterface.OnClickListener
{
  public dmi(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    RegisterSendUpSms.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmi
 * JD-Core Version:    0.7.0.1
 */
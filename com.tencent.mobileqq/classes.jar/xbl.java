import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class xbl
  implements DialogInterface.OnClickListener
{
  public xbl(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SendHbActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbl
 * JD-Core Version:    0.7.0.1
 */
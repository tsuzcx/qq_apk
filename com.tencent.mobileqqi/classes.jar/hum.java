import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class hum
  implements DialogInterface.OnClickListener
{
  public hum(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hum
 * JD-Core Version:    0.7.0.1
 */
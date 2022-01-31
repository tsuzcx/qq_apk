import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class fgk
  implements DialogInterface.OnClickListener
{
  public fgk(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgk
 * JD-Core Version:    0.7.0.1
 */
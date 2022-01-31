import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class fgp
  implements DialogInterface.OnClickListener
{
  public fgp(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgp
 * JD-Core Version:    0.7.0.1
 */
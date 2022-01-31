import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class tro
  implements DialogInterface.OnClickListener
{
  public tro(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.show();
    this.a.b = false;
    SendMultiPictureHelper.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tro
 * JD-Core Version:    0.7.0.1
 */
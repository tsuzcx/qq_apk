import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public abstract class yaj
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
  public abstract void a();
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yaj
 * JD-Core Version:    0.7.0.1
 */
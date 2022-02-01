import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class iag
  implements DialogInterface.OnClickListener
{
  public iag(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iag
 * JD-Core Version:    0.7.0.1
 */
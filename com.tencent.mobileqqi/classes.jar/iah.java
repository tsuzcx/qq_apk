import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class iah
  implements DialogInterface.OnClickListener
{
  public iah(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iah
 * JD-Core Version:    0.7.0.1
 */
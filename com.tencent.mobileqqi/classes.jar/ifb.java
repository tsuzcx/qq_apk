import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ifb
  implements DialogInterface.OnClickListener
{
  public ifb(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ifb
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class fes
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      System.exit(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fes
 * JD-Core Version:    0.7.0.1
 */
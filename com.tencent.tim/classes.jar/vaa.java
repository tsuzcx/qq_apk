import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class vaa
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vaa
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class amxo
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.search.util.VADHelper.Gy = false;
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxo
 * JD-Core Version:    0.7.0.1
 */
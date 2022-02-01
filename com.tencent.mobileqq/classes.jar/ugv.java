import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ugv
  implements DialogInterface.OnClickListener
{
  ugv(int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    unx.b(112, 2, 0);
    uno.a(117, this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugv
 * JD-Core Version:    0.7.0.1
 */
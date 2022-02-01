import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class tpt
  implements DialogInterface.OnClickListener
{
  tpt(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.onClick(paramDialogInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpt
 * JD-Core Version:    0.7.0.1
 */
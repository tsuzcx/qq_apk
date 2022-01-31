import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ycv
  implements DialogInterface.OnClickListener
{
  public ycv(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((Activity)this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycv
 * JD-Core Version:    0.7.0.1
 */
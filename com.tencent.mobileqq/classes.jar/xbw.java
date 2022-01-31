import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class xbw
  implements DialogInterface.OnClickListener
{
  public xbw(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setResult(-1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbw
 * JD-Core Version:    0.7.0.1
 */
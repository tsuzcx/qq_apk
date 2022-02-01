import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

public final class arky
  implements DialogInterface.OnClickListener
{
  public arky(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    arlb.ejS();
    FloatingScreenPermission.requestPermission(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arky
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;

public class uv
  implements DialogInterface.OnClickListener
{
  public uv(AboutActivity paramAboutActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     uv
 * JD-Core Version:    0.7.0.1
 */
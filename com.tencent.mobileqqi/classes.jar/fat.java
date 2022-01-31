import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class fat
  implements DialogInterface.OnClickListener
{
  public fat(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (Build.VERSION.SDK_INT > 10)
    {
      this.a.startActivity(new Intent("android.settings.SETTINGS"));
      return;
    }
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fat
 * JD-Core Version:    0.7.0.1
 */
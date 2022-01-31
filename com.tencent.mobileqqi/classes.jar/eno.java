import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;

public class eno
  implements DialogInterface.OnClickListener
{
  public eno(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a.a, GesturePWDSettingActivity.class);
    localIntent.putExtra("key_reset", true);
    this.a.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eno
 * JD-Core Version:    0.7.0.1
 */
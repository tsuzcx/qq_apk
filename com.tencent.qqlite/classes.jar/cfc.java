import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;

public class cfc
  implements DialogInterface.OnClickListener
{
  public cfc(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a.a, GesturePWDSettingActivity.class);
    localIntent.putExtra("key_reset", true);
    this.a.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cfc
 * JD-Core Version:    0.7.0.1
 */
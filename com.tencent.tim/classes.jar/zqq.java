import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class zqq
  implements DialogInterface.OnClickListener
{
  public zqq(DialogBaseActivity paramDialogBaseActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.bsr)
    {
      paramDialogInterface = new Intent(BaseActivity.sTopActivity, SplashActivity.class);
      paramDialogInterface.putExtra("main_tab_id", 1);
      paramDialogInterface.setFlags(603979776);
      BaseActivity.sTopActivity.startActivity(paramDialogInterface);
      this.a.finish();
      anot.a(this.a.app, "dc00898", "", "", "0X8006AA6", "0X8006AA6", 0, 0, "", "", "", "");
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqq
 * JD-Core Version:    0.7.0.1
 */
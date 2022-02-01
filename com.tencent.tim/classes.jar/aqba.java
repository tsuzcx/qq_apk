import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity.15.1;
import mqq.os.MqqHandler;

public class aqba
  implements DialogInterface.OnClickListener
{
  public aqba(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    arwt.i("qqBaseActivity", arud.b(10010, 1, 3, 200));
    arub.a().postReport(17, arud.b(10010, 1, 3, 200));
    arzk.a();
    if (!arzk.aHx()) {
      arxa.a().showToast(acfp.m(2131716255));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      aqai.v(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqba
 * JD-Core Version:    0.7.0.1
 */
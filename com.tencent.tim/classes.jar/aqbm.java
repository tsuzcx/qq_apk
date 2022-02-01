import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;

public class aqbm
  implements DialogInterface.OnClickListener
{
  public aqbm(UpgradeDetailActivity paramUpgradeDetailActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      aqap.a().startDownload(false);
      paramDialogInterface.dismiss();
      UpgradeDetailActivity.a(this.a, this.dYp, 3);
      return;
    }
    UpgradeDetailActivity.a(this.a, this.a, this.dYp);
    paramDialogInterface.dismiss();
    UpgradeDetailActivity.a(this.a, this.dYp, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqbm
 * JD-Core Version:    0.7.0.1
 */
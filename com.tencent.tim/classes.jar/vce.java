import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class vce
  implements DialogInterface.OnClickListener
{
  public vce(GeneralSettingActivity paramGeneralSettingActivity, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof aqju)) {
      ((aqju)paramDialogInterface).setOnDismissListener(null);
    }
    this.dR.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vce
 * JD-Core Version:    0.7.0.1
 */
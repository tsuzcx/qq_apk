import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;

public class aqau
  implements DialogInterface.OnKeyListener
{
  public aqau(UpgradeActivity paramUpgradeActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.edl();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqau
 * JD-Core Version:    0.7.0.1
 */
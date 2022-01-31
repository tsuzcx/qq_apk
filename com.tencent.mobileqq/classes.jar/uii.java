import android.app.ProgressDialog;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

public class uii
  implements ConditionSearchManager.IConfigListener
{
  public uii(TroopRobotPickerActivity paramTroopRobotPickerActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    TroopRobotPickerActivity.a(this.a);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uii
 * JD-Core Version:    0.7.0.1
 */
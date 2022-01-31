import android.app.ProgressDialog;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

public class uao
  implements ConditionSearchManager.IConfigListener
{
  public uao(TroopRobotPickerActivity paramTroopRobotPickerActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    TroopRobotPickerActivity.a(this.a);
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uao
 * JD-Core Version:    0.7.0.1
 */
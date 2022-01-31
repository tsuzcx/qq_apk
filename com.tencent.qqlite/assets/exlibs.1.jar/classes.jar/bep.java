import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;

public class bep
  implements View.OnClickListener
{
  public bep(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a(), NearbyTroopsActivity.class);
    paramView.putExtra("from", 4);
    paramView.putExtra("mode", 0);
    this.a.a(paramView);
    ReportController.b(this.a.a, "CliOper", "", "", "Open_group", "Around_grp", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bep
 * JD-Core Version:    0.7.0.1
 */
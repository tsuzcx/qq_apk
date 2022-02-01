import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;

public class gpu
  implements View.OnClickListener
{
  public gpu(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
    paramView.putExtra("url", this.a.a);
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
    ReportController.b(this.a.b, "P_CliOper", "Grp_nearby", "", "hot", "Clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gpu
 * JD-Core Version:    0.7.0.1
 */
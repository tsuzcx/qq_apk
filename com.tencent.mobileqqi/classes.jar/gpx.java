import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class gpx
  implements ActionSheet.OnDismissListener
{
  public gpx(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a.b, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_order", 0, 0, "3", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gpx
 * JD-Core Version:    0.7.0.1
 */
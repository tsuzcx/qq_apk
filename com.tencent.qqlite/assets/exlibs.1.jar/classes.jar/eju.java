import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class eju
  implements View.OnClickListener
{
  public eju(NearbyTroopsView paramNearbyTroopsView) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
    paramView.putExtra("url", this.a.jdField_a_of_type_JavaLangString);
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("hide_more_button", true);
    this.a.b(paramView);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "hot", "Clk", 0, 0, "", "", "", "");
    this.a.h = false;
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eju
 * JD-Core Version:    0.7.0.1
 */
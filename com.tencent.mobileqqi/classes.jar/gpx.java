import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gpx
  implements ActionSheet.OnButtonClickListener
{
  public gpx(NearbyTroopsActivity paramNearbyTroopsActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      paramView = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.b.getManager(30);
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity, 2);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.b, "P_CliOper", "Grp_nearby", "", "right", "create", 0, 0, "", "", "", "");
      continue;
      TroopQQBrowserHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.b.a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity.b, "P_CliOper", "Grp_nearby", "", "right", "find", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gpx
 * JD-Core Version:    0.7.0.1
 */
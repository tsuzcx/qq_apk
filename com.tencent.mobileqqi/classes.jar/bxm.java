import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class bxm
  implements View.OnClickListener
{
  public bxm(AboutActivity paramAboutActivity, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem) {}
  
  public void onClick(View paramView)
  {
    AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.b, "CliOper", "", "", "Setting_tab", "Clk_about_help", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxm
 * JD-Core Version:    0.7.0.1
 */
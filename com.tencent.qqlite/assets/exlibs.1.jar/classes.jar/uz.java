import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class uz
  implements View.OnClickListener
{
  public uz(AboutActivity paramAboutActivity, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem) {}
  
  public void onClick(View paramView)
  {
    AboutConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("com.tx.abouthelp")) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "Setting_tab", "Clk_about_help", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     uz
 * JD-Core Version:    0.7.0.1
 */
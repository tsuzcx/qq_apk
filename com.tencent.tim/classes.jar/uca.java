import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uca
  implements View.OnClickListener
{
  public uca(AboutActivity paramAboutActivity, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem) {}
  
  public void onClick(View paramView)
  {
    aehl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("tim.tx.android.feedback")) {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005742", "0X8005742", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.l.setRightIcon(null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("tim.tx.help")) {
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005741", "0X8005741", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("com.tx.aboutfunction_8_0_3")) {
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005744", "0X8005744", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("tim.tx.yinsi")) {
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005743", "0X8005743", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uca
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ubx
  implements View.OnClickListener
{
  public ubx(AboutActivity paramAboutActivity, aizo paramaizo) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aizo.mUrl))
    {
      ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.getManager(256)).cl(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_Aizo.mUrl);
      anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X800865C", "0X800865C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Aizo.dvI();
    AboutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubx
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import protocol.KQQConfig.UpgradeInfo;

public class uby
  implements View.OnClickListener
{
  public uby(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    arzk.a();
    Intent localIntent;
    if (arzk.aHx())
    {
      if (aqma.aEV()) {
        i = 1;
      }
      anot.a(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      localIntent.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      localIntent.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((AboutActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a != null) && (aqma.mx(AboutActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn)))
      {
        if (aqma.aEV()) {
          i = 1;
        }
        anot.a(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
        localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
        localIntent.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
        localIntent.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
        localIntent.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
        localIntent.putExtra("activity_type", 4096);
        if (BaseActivity.sTopActivity != null) {
          BaseActivity.sTopActivity.startActivity(localIntent);
        }
      }
      else if ((AboutActivity.a(this.a) != null) && (AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
      {
        anot.a(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", aqap.BI(), "");
        UpgradeDetailActivity.a(this.a, aqap.a().b(), false, false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uby
 * JD-Core Version:    0.7.0.1
 */
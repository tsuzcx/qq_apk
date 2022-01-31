import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.os.MqqHandler;

public class xfz
  implements View.OnClickListener
{
  public xfz(BannerManager paramBannerManager, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), IndividuationUrlHelper.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), "themeDetail", this.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
    BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).obtainMessage(12).sendToTarget();
    ReportController.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfz
 * JD-Core Version:    0.7.0.1
 */
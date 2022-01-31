import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.recent.Banner;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.ADView;

public class est
  implements View.OnClickListener
{
  public est(BannerManager paramBannerManager, View paramView, int paramInt, FrameLayout paramFrameLayout, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (PushBanner)paramView.getTag();
    if (localObject != null)
    {
      paramView = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).b.getAccount();
      ReportController.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).b, "CliOper", "", paramView, "Push_Banner", "Click_Banner", 0, 0, "", "", "", "");
      ((PushBanner)localObject).a.a();
      localObject = (ADView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232085);
      if (localObject != null)
      {
        if (((ADView)localObject).a(0) <= 1) {
          break label149;
        }
        ((ADView)localObject).a(0, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
    }
    for (;;)
    {
      Config.a.b(this.jdField_a_of_type_JavaLangString);
      paramView = new ConfigManager(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getApplicationContext(), ConfigServlet.d);
      if (paramView != null)
      {
        paramView.b();
        paramView.c();
      }
      return;
      label149:
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getSharedPreferences("mobileQQi", 0).edit().putBoolean("push_banner_display" + paramView, false).commit();
      paramView = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager)[14];
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidViewView != null))
      {
        paramView = (ADView)paramView.jdField_a_of_type_AndroidViewView.findViewById(2131232085);
        if (paramView != null) {
          paramView.a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(14, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     est
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.utils.JumpAction;

public class xgj
  implements View.OnClickListener
{
  public xgj(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = (PushBanner)paramView.getTag();
    if (paramView != null) {
      paramView.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a();
    }
    try
    {
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        i = Integer.parseInt(paramView.jdField_a_of_type_JavaLangString);
        ReportController.b(BannerManager.a(this.a).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        paramView = new ConfigManager(BannerManager.a(this.a).getApplicationContext(), ConfigServlet.jdField_a_of_type_JavaLangString);
        if (paramView != null)
        {
          paramView.b();
          paramView.c();
        }
        return;
      }
    }
    catch (Throwable paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        int i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgj
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

public class xoy
  implements View.OnClickListener
{
  public xoy(BannerManager paramBannerManager, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager) != null)
    {
      paramView = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).obtainMessage(30);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendMessageDelayed(paramView, 2500L);
    }
    paramView = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty(paramView)) {}
    try
    {
      paramView = Class.forName(paramView);
      if (paramView != null)
      {
        paramView = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getApplicationContext(), paramView);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("action");
        if (!TextUtils.isEmpty(str)) {
          paramView.setAction(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("category");
        if (!TextUtils.isEmpty(str)) {
          paramView.addCategory(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
        if (!TextUtils.isEmpty(str)) {
          paramView.putExtra("url", str);
        }
        paramView.setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        paramView.putExtra("back_from_aio", true);
        BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).startActivity(paramView);
      }
      return;
    }
    catch (ClassNotFoundException paramView)
    {
      for (;;)
      {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xoy
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class esz
  implements View.OnClickListener
{
  public esz(BannerManager paramBannerManager, VipBannerInfo paramVipBannerInfo, RedTouchManager paramRedTouchManager, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.c;
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.e)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.a, 3);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).removeMessages(9);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendEmptyMessage(9);
      return;
      VipUtils.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      VipUtils.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     esz
 * JD-Core Version:    0.7.0.1
 */
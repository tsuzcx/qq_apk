import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.net.URLEncoder;

public class xiv
  implements View.OnClickListener
{
  public xiv(BannerManager paramBannerManager, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager)) {
      return;
    }
    BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager, false);
    new Handler().postDelayed(new xiw(this), 1000L);
    paramView = ((QQAppInterface)BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getAppRuntime()).getCurrentAccountUin();
    Object localObject = new StringBuilder(this.jdField_a_of_type_JavaLangString + "&ADTAG=aio.run.click");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("&plat=1");
    ((StringBuilder)localObject).append("&app=1");
    ((StringBuilder)localObject).append("&version=7.6.3.3560");
    ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
    ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.openQQBrowserActivity(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), (String)localObject, 32768L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xiv
 * JD-Core Version:    0.7.0.1
 */
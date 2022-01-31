import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import org.json.JSONObject;

public class xov
  implements View.OnClickListener
{
  public xov(BannerManager paramBannerManager, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("from", "20");
      label17:
      Intent localIntent = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).startActivity(localIntent);
      VipComicReportUtils.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xov
 * JD-Core Version:    0.7.0.1
 */
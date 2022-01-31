import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class xpm
  implements View.OnClickListener
{
  public xpm(BannerManager paramBannerManager, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    paramView = IndividuationUrlHelper.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), "theme", "mvip.gongneng.android.theme.index_dynamic_tab");
    Object localObject = new StringBuilder().append(paramView);
    if (paramView.contains("?"))
    {
      paramView = "&";
      paramView = paramView;
      localObject = paramView + "dialog_source=other&authresult=" + this.jdField_a_of_type_Int;
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (!((String)localObject).contains("id=[id]")) {
          break label232;
        }
      }
    }
    label232:
    for (paramView = ((String)localObject).replace("[id]", this.jdField_a_of_type_JavaLangString);; paramView = (String)localObject + "&id=" + this.jdField_a_of_type_JavaLangString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "theme market url: " + paramView);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), paramView, 32L, localIntent, true, -1);
      ReportController.b(null, "CliOper", "", "", "theme", "0X8007233", 0, 0, String.valueOf(this.b), "", "", "");
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).obtainMessage(16).sendToTarget();
      return;
      paramView = "?";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpm
 * JD-Core Version:    0.7.0.1
 */
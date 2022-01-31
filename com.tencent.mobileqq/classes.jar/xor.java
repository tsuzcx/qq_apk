import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

public class xor
  implements View.OnClickListener
{
  public xor(BannerManager paramBannerManager, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager) != null)
    {
      paramView = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).obtainMessage(1134028);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.setAction("cooperation.qqreader.aioback2reader");
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("is_from_conversation", true);
    BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xor
 * JD-Core Version:    0.7.0.1
 */
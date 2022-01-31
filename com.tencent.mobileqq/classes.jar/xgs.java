import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager.IBannerInteract;
import com.tencent.mobileqq.activity.recent.BannerManager.MessageToShowBanner;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class xgs
  implements View.OnClickListener
{
  private BannerManager.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public xgs(BannerManager.MessageToShowBanner paramMessageToShowBanner, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner = paramMessageToShowBanner;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.jdField_a_of_type_JavaLangString + " on enter");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$IBannerInteract.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgs
 * JD-Core Version:    0.7.0.1
 */
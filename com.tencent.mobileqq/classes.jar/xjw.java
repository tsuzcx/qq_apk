import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager.IBannerInteract;
import com.tencent.mobileqq.activity.recent.BannerManager.MessageToShowBanner;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class xjw
  implements View.OnClickListener
{
  private BannerManager.MessageToShowBanner jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public xjw(BannerManager.MessageToShowBanner paramMessageToShowBanner, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner = paramMessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.jdField_a_of_type_JavaLangString + " on close");
    }
    paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(201);
    paramView.obj = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager$IBannerInteract.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjw
 * JD-Core Version:    0.7.0.1
 */
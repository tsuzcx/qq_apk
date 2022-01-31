import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.qphone.base.util.QLog;

class vpl
  implements Runnable
{
  vpl(vpk paramvpk, AIOAnimationControlManager.DownloadGftData paramDownloadGftData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$DownloadGftData.a)
    {
      this.jdField_a_of_type_Vpk.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.jdField_a_of_type_Vpk.a.uniseq);
      }
      ((AIOAnimationControlManager)vpk.a(this.jdField_a_of_type_Vpk).getManager(222)).b(this.jdField_a_of_type_Vpk);
      this.jdField_a_of_type_Vpk.c.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + this.jdField_a_of_type_Vpk.a.uniseq);
    }
    this.jdField_a_of_type_Vpk.a.isLoading = true;
    this.jdField_a_of_type_Vpk.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpl
 * JD-Core Version:    0.7.0.1
 */
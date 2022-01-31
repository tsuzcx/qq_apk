import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.qphone.base.util.QLog;

class vki
  implements Runnable
{
  vki(vkh paramvkh, AIOAnimationControlManager.DownloadGftData paramDownloadGftData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$DownloadGftData.a)
    {
      this.jdField_a_of_type_Vkh.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.jdField_a_of_type_Vkh.a.uniseq);
      }
      ((AIOAnimationControlManager)vkh.a(this.jdField_a_of_type_Vkh).getManager(222)).b(this.jdField_a_of_type_Vkh);
      this.jdField_a_of_type_Vkh.c.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + this.jdField_a_of_type_Vkh.a.uniseq);
    }
    this.jdField_a_of_type_Vkh.a.isLoading = true;
    this.jdField_a_of_type_Vkh.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vki
 * JD-Core Version:    0.7.0.1
 */